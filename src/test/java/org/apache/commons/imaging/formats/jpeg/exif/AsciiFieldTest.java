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

package org.apache.commons.imaging.formats.jpeg.exif;

import java.io.File;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.Sanselan;
import org.apache.commons.imaging.common.IImageMetadata;
import org.apache.commons.imaging.formats.jpeg.JpegImageMetadata;
import org.apache.commons.imaging.formats.tiff.TiffField;
import org.apache.commons.imaging.formats.tiff.TiffImageMetadata;
import org.apache.commons.imaging.formats.tiff.constants.AllTagConstants;
import org.apache.commons.imaging.formats.tiff.constants.TiffTagConstants;

public class AsciiFieldTest extends ExifBaseTest implements AllTagConstants {

    public void testSingleImage() throws Exception {
        File imageFile = getTestImageByName("Canon Powershot SD750 - 2007.12.26.n.IMG_3704.JPG");

        Map params = new HashMap();

        IImageMetadata metadata = Sanselan.getMetadata(imageFile, params);
        assertNotNull(metadata);
        JpegImageMetadata jpegMetadata = (JpegImageMetadata) metadata;

        // note that exif might be null if no Exif metadata is found.
        TiffImageMetadata exif = jpegMetadata.getExif();
        if (null == exif)
            return;

        List<TiffField> fields = exif.getAllFields();
        Map<Integer, TiffField> fieldMap = new Hashtable<>();
        // Build a simplified field tag -> field map, ignoring directory structures.
        // Good enough for our purposes, since the image in question is known.
        fields.forEach(field -> fieldMap.put(field.tag, field));

        Map<Integer, String> expectedFieldValues = new Hashtable<>();
        expectedFieldValues.put(TiffTagConstants.TIFF_TAG_MAKE.tag, "Canon");
        expectedFieldValues.put(TiffTagConstants.TIFF_TAG_MODEL.tag, "Canon PowerShot SD750");
        expectedFieldValues.put(TiffTagConstants.TIFF_TAG_DATE_TIME.tag, "2007:12:25 13:34:39");
        expectedFieldValues.forEach((tag, expectedValue) -> {
            try {
            assertTrue(fieldMap.containsKey(tag));
            TiffField field = fieldMap.get(tag);
            assertNotNull(field);
            Object value = field.getValue();
            assertNotNull(value);
            assertEquals(value, expectedValue);
            } catch (ImageReadException e) {
                fail("Something went wrong " +  e.getMessage());
            }
        });
    }
}
