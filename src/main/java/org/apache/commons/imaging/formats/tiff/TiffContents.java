/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.imaging.formats.tiff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.formats.tiff.taginfos.TagInfo;
import org.apache.commons.imaging.util.Debug;

public class TiffContents {
    public final TiffHeader header;
    public final List<TiffDirectory> directories;

    public TiffContents(TiffHeader tiffHeader, List<TiffDirectory> directories) {
        this.header = tiffHeader;
        this.directories = directories;
    }

    public List<TiffElement> getElements() throws ImageReadException {
        List<TiffElement> result = new ArrayList<TiffElement>();

        result.add(header);

        for (int i = 0; i < directories.size(); i++) {
            TiffDirectory directory = directories.get(i);

            result.add(directory);

            List<TiffField> fields = directory.entries;
            for (int j = 0; j < fields.size(); j++) {
                TiffField field = fields.get(j);
                TiffElement oversizeValue = field.getOversizeValueElement();
                if (null != oversizeValue)
                    result.add(oversizeValue);
            }

            if (directory.hasTiffImageData())
                result.addAll(directory.getTiffRawImageDataElements());
            if (directory.hasJpegImageData())
                result.add(directory.getJpegRawImageDataElement());
        }

        return result;
    }

    public TiffField findField(TagInfo tag) throws ImageReadException {
        for (int i = 0; i < directories.size(); i++) {
            TiffDirectory directory = directories.get(i);

            TiffField field = directory.findField(tag);
            if (null != field)
                return field;
        }

        return null;
    }

    public void dissect(boolean verbose) throws ImageReadException {
        List<TiffElement> elements = getElements();
        elements.sort(TiffElement.COMPARATOR);

        int lastEnd = 0;
        for (TiffElement element : elements) {
            if (element.offset > lastEnd)
                Debug.debug("\t" + "gap: " + (element.offset - lastEnd));
            if (element.offset < lastEnd)
                Debug.debug("\t" + "overlap");

            Debug.debug("element, start: " + element.offset + ", length: "
                    + element.length + ", end: "
                    + (element.offset + element.length) + ": "
                    + element.getElementDescription(false));
            if (verbose) {
                String verbosity = element.getElementDescription(true);
                if (null != verbosity)
                    Debug.debug(verbosity);
            }

            lastEnd = element.offset + element.length;
        }
        Debug.debug("end: " + lastEnd);
        Debug.debug();
    }

}