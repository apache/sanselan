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

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.common.bytesource.ByteSource;
import org.apache.commons.imaging.formats.tiff.constants.ExifTagConstants;
import org.apache.commons.imaging.formats.tiff.constants.GpsTagConstants;
import org.apache.commons.imaging.formats.tiff.constants.TiffConstants;
import org.apache.commons.imaging.formats.tiff.constants.TiffDirectoryType;
import org.apache.commons.imaging.formats.tiff.constants.TiffTagConstants;
import org.apache.commons.imaging.formats.tiff.fieldtypes.FieldType;
import org.apache.commons.imaging.formats.tiff.taginfos.TagInfo;

public class TiffField implements TiffConstants {
    public final TagInfo tagInfo;
    public final FieldType fieldType;

    public final int tag;
    public final int directoryType;
    public final int type;
    public final int length;
    public final int valueOffset;
    public final byte valueOffsetBytes[];

    public byte oversizeValue[] = null;
    public final int byteOrder;

    public TiffField(int tag, int directoryType, int type, int Length,
                     int ValueOffset, byte ValueOffsetBytes[], int byteOrder) {

        this.tag = tag;
        this.directoryType = directoryType;
        this.type = type;
        this.length = Length;
        this.valueOffset = ValueOffset;
        this.valueOffsetBytes = ValueOffsetBytes;
        this.byteOrder = byteOrder;

        fieldType = getFieldType(type);
        tagInfo = getTag(directoryType, tag);
    }

    private int sortHint = -1;

    public boolean isLocalValue() {
        return fieldType.isLocalValue(this);
    }

    public int getBytesLength() throws ImageReadException {
        return fieldType.getBytesLength(this);
    }

    public final class OversizeValueElement extends TiffElement {
        public OversizeValueElement(int offset, int length) {
            super(offset, length);
        }

        @Override
        public String getElementDescription(boolean verbose) {
            if (verbose)
                return null;

            return "OversizeValueElement, tag: " + tagInfo.name
                    + ", fieldType: " + fieldType.name;
        }
    }

    public TiffElement getOversizeValueElement() {
        if (fieldType.isLocalValue(this))
            return null;

        return new OversizeValueElement(valueOffset, oversizeValue.length);
    }

    public void setOversizeValue(byte bytes[]) {
        this.oversizeValue = bytes;
    }

    private static FieldType getFieldType(int value) {
        for (int i = 0; i < FIELD_TYPES.size(); i++) {
            FieldType fieldType = FIELD_TYPES.get(i);
            if (fieldType.type == value)
                return fieldType;
        }

        return FIELD_TYPE_UNKNOWN;
    }

    private static TagInfo getTag(int directoryType, int tag,
                                  List<TagInfo> possibleMatches) {
        // Please keep this method in sync with TiffImageMetadata's findField()

        if (possibleMatches.size() < 1)
            return null;
        // else if (possibleMatches.size() == 1)
        // {
        // TagInfo tagInfo = (TagInfo) possibleMatches.get(0);
        // return tagInfo;
        // }

        // first search for exact match.
        for (int i = 0; i < possibleMatches.size(); i++) {
            TagInfo tagInfo = possibleMatches.get(i);
            if (tagInfo.directoryType == TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN)
                // pass
                continue;
            else if (directoryType == tagInfo.directoryType.directoryType)
                return tagInfo;
        }

        // accept an inexact match.
        for (int i = 0; i < possibleMatches.size(); i++) {
            TagInfo tagInfo = possibleMatches.get(i);

            if (tagInfo.directoryType == TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN)
                // pass
                continue;
            else if (directoryType >= 0
                    && tagInfo.directoryType.isImageDirectory())
                return tagInfo;
            else if (directoryType < 0
                    && !tagInfo.directoryType.isImageDirectory())
                return tagInfo;
        }

        // accept a wildcard match.
        for (int i = 0; i < possibleMatches.size(); i++) {
            TagInfo tagInfo = possibleMatches.get(i);

            if (tagInfo.directoryType == TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN)
                return tagInfo;
        }

        // // accept a very rough match.
        // for (int i = 0; i < possibleMatches.size(); i++)
        // {
        // TagInfo tagInfo = (TagInfo) possibleMatches.get(i);
        // if (tagInfo.exifDirectory == EXIF_DIRECTORY_UNKNOWN)
        // return tagInfo;
        // else if (directoryType == DIRECTORY_TYPE_EXIF
        // && tagInfo.exifDirectory == EXIF_DIRECTORY_EXIF_IFD)
        // return tagInfo;
        // else if (directoryType == DIRECTORY_TYPE_INTEROPERABILITY
        // && tagInfo.exifDirectory == EXIF_DIRECTORY_INTEROP_IFD)
        // return tagInfo;
        // else if (directoryType == DIRECTORY_TYPE_GPS
        // && tagInfo.exifDirectory == EXIF_DIRECTORY_GPS)
        // return tagInfo;
        // else if (directoryType == DIRECTORY_TYPE_MAKER_NOTES
        // && tagInfo.exifDirectory == EXIF_DIRECTORY_MAKER_NOTES)
        // return tagInfo;
        // else if (directoryType >= 0
        // && tagInfo.exifDirectory.isImageDirectory())
        // return tagInfo;
        // else if (directoryType < 0
        // && !tagInfo.exifDirectory.isImageDirectory())
        // return tagInfo;
        // }

        return TiffTagConstants.TIFF_TAG_UNKNOWN;

        // if (true)
        // throw new Error("Why didn't this algorithm work?");
        //
        // {
        // TagInfo tagInfo = (TagInfo) possibleMatches.get(0);
        // return tagInfo;
        // }

        // Object key = new Integer(tag);
        //
        // if (directoryType == DIRECTORY_TYPE_EXIF
        // || directoryType == DIRECTORY_TYPE_INTEROPERABILITY)
        // {
        // if (EXIF_TAG_MAP.containsKey(key))
        // return (TagInfo) EXIF_TAG_MAP.get(key);
        // }
        // else if (directoryType == DIRECTORY_TYPE_GPS)
        // {
        // if (GPS_TAG_MAP.containsKey(key))
        // return (TagInfo) GPS_TAG_MAP.get(key);
        // }
        // else
        // {
        // if (TIFF_TAG_MAP.containsKey(key))
        // return (TagInfo) TIFF_TAG_MAP.get(key);
        // }
        //
        // if (ALL_TAG_MAP.containsKey(key))
        // return (TagInfo) ALL_TAG_MAP.get(key);

        // public static final int DIRECTORY_TYPE_EXIF = -2;
        // // public static final int DIRECTORY_TYPE_SUB = 5;
        // public static final int DIRECTORY_TYPE_GPS = -3;
        // public static final int DIRECTORY_TYPE_INTEROPERABILITY = -4;
        //
        // private static final Map GPS_TAG_MAP = makeTagMap(ALL_GPS_TAGS,
        // false);
        // private static final Map TIFF_TAG_MAP = makeTagMap(ALL_TIFF_TAGS,
        // false);
        // private static final Map EXIF_TAG_MAP = makeTagMap(ALL_EXIF_TAGS,
        // false);
        // private static final Map ALL_TAG_MAP = makeTagMap(ALL_TAGS, true);
        //
        // for (int i = 0; i < ALL_TAGS.length; i++)
        // {
        // TagInfo2 tag = ALL_TAGS[i];
        // if (tag.tag == value)
        // return tag;
        // }

        // return TIFF_TAG_UNKNOWN;
    }

    private static TagInfo getTag(int directoryType, int tag) {
        List<TagInfo> possibleMatches = ALL_TAG_MAP.get(tag);

        if (null == possibleMatches) {
            return TiffTagConstants.TIFF_TAG_UNKNOWN;
        }

        TagInfo result = getTag(directoryType, tag, possibleMatches);
        return result;
    }

    private int getValueLengthInBytes() {
        int unit_length = fieldType.length;
        int valueLength = unit_length * length;

        // Debug.debug("getValueLengthInBytes unit_length", unit_length);
        // Debug.debug("getValueLengthInBytes length", length);

        return valueLength;
    }

    public void fillInValue(ByteSource byteSource) throws IOException, TiffValueOutsideFileBoundsException {
        if (fieldType.isLocalValue(this))
            return;

        int valueLength = getValueLengthInBytes();
        long valueLengthLong = 0xffffffffL & valueLength;

        // Debug.debug("fillInValue tag", tag);
        // Debug.debug("fillInValue tagInfo", tagInfo);
        // Debug.debug("fillInValue valueOffset", valueOffset);
        // Debug.debug("fillInValue valueLength", valueLength);

        if (valueOffset < 0 ||
                valueOffset + valueLengthLong > byteSource.getLength()) {
            throw new TiffValueOutsideFileBoundsException(
                    "Attempt to read byte range starting from " + valueOffset + " " +
                            "of length " + valueLength + " " +
                            "which is outside the file's size of " + byteSource.getLength());
        }
        byte bytes[] = byteSource.getBlock(valueOffset, valueLength);
        setOversizeValue(bytes);
    }

    public String getValueDescription() {
        try {
            return getValueDescription(getValue());
        } catch (ImageReadException e) {
            return "Invalid value: " + e.getMessage();
        }
    }

    private String getValueDescription(Object o) {
        if (o == null)
            return null;

        if (o instanceof Number) {
            return o.toString();
        } else if (o instanceof String) {
            return "'" + o.toString().trim() + "'";
        } else if (o instanceof Date) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
            return df.format((Date) o);
        } else if (o instanceof Object[]) {
            Object objects[] = (Object[]) o;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < objects.length; i++) {
                Object object = objects[i];

                if (i > 50) {
                    result.append("... (" + objects.length + ")");
                    break;
                }
                if (i > 0)
                    result.append(", ");
                result.append("" + object);
            }
            return result.toString();
        }
        // else if (o instanceof Number[])
        // {
        // Number numbers[] = (Number[]) o;
        // StringBuilder result = new StringBuilder();
        //
        // for (int i = 0; i < numbers.length; i++)
        // {
        // Number number = numbers[i];
        //
        // if (i > 0)
        // result.append(", ");
        // result.append("" + number);
        // }
        // return result.toString();
        // }
        else if (o instanceof short[]) {
            short values[] = (short[]) o;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < values.length; i++) {
                short value = values[i];

                if (i > 50) {
                    result.append("... (" + values.length + ")");
                    break;
                }
                if (i > 0)
                    result.append(", ");
                result.append("" + value);
            }
            return result.toString();
        } else if (o instanceof int[]) {
            int values[] = (int[]) o;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < values.length; i++) {
                int value = values[i];

                if (i > 50) {
                    result.append("... (" + values.length + ")");
                    break;
                }
                if (i > 0)
                    result.append(", ");
                result.append("" + value);
            }
            return result.toString();
        } else if (o instanceof long[]) {
            long values[] = (long[]) o;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < values.length; i++) {
                long value = values[i];

                if (i > 50) {
                    result.append("... (" + values.length + ")");
                    break;
                }
                if (i > 0)
                    result.append(", ");
                result.append("" + value);
            }
            return result.toString();
        } else if (o instanceof double[]) {
            double values[] = (double[]) o;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < values.length; i++) {
                double value = values[i];

                if (i > 50) {
                    result.append("... (" + values.length + ")");
                    break;
                }
                if (i > 0)
                    result.append(", ");
                result.append("" + value);
            }
            return result.toString();
        } else if (o instanceof byte[]) {
            byte values[] = (byte[]) o;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < values.length; i++) {
                byte value = values[i];

                if (i > 50) {
                    result.append("... (" + values.length + ")");
                    break;
                }
                if (i > 0)
                    result.append(", ");
                result.append("" + value);
            }
            return result.toString();
        } else if (o instanceof char[]) {
            char values[] = (char[]) o;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < values.length; i++) {
                char value = values[i];

                if (i > 50) {
                    result.append("... (" + values.length + ")");
                    break;
                }
                if (i > 0)
                    result.append(", ");
                result.append("" + value);
            }
            return result.toString();
        } else if (o instanceof float[]) {
            float values[] = (float[]) o;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < values.length; i++) {
                float value = values[i];

                if (i > 50) {
                    result.append("... (" + values.length + ")");
                    break;
                }
                if (i > 0)
                    result.append(", ");
                result.append("" + value);
            }
            return result.toString();
        }
        // else if (o instanceof short[])
        // {
        // short numbers[] = (short[]) o;
        // StringBuilder result = new StringBuilder();
        //
        // for (int i = 0; i < numbers.length; i++)
        // {
        // short number = numbers[i];
        //
        // if (i > 0)
        // result.append(", ");
        // result.append("" + number);
        // }
        // return result.toString();
        // }

        return "Unknown: " + o.getClass().getName();
    }

    public void dump() {
        PrintWriter pw = new PrintWriter(System.out);
        dump(pw);
        pw.flush();
    }

    public void dump(PrintWriter pw) {
        dump(pw, null);
    }

    public void dump(PrintWriter pw, String prefix) {
        if (prefix != null)
            pw.print(prefix + ": ");

        pw.println(toString());
        pw.flush();
    }

    // private void errorDump()
    // {
    // Debug.debug("tagInfo", tagInfo);
    // Debug.debug("fieldType", fieldType);
    // Debug.debug("tag", tag);
    // Debug.debug("type", type);
    // Debug.debug("length", length);
    // Debug.debug("valueOffset", valueOffset);
    // Debug.debug("valueOffsetBytes", valueOffsetBytes);
    // Debug.debug("oversizeValue", oversizeValue);
    // Debug.debug("byteOrder", byteOrder);
    // }

    public String getDescriptionWithoutValue() {
        return tag + " (0x" + Integer.toHexString(tag) + ": " + tagInfo.name
                + "): ";
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append(tag + " (0x" + Integer.toHexString(tag) + ": "
                + tagInfo.name + "): ");
        result.append(getValueDescription() + " (" + length + " "
                + fieldType.name + ")");

        return result.toString();
    }

    public String getTagName() {
        if (tagInfo == TiffTagConstants.TIFF_TAG_UNKNOWN)
            return tagInfo.name + " (0x" + Integer.toHexString(tag) + ")";
        return tagInfo.name;
    }

    public String getFieldTypeName() {
        return fieldType.name;
    }

    public static final String Attribute_Tag = "Tag";

    public Object getValue() throws ImageReadException {
        // System.out.print("getValue");
        return tagInfo.getValue(this);
    }

    public String getStringValue() throws ImageReadException {
        Object o = getValue();
        if (o == null)
            return null;
        if (!(o instanceof String))
            throw new ImageReadException("Expected String value("
                    + tagInfo.getDescription() + "): " + o);
        return (String) o;
    }

    private static final Map<Object, List<TagInfo>> makeTagMap(List<TagInfo> tags) {
        // make sure to use the thread-safe version; this is shared state.
        Map<Object, List<TagInfo>> map = new Hashtable<>();

        for (int i = 0; i < tags.size(); i++) {
            TagInfo tag = tags.get(i);

            List<TagInfo> tagList = map.get(tag.tag);
            if (tagList == null) {
                tagList = new ArrayList<TagInfo>();
                map.put(tag.tag, tagList);
            }
            tagList.add(tag);
        }

        return map;
    }

    private static final Map<Object, List<TagInfo>> ALL_TAG_MAP = makeTagMap(ALL_TAGS);

    public int[] getIntArrayValue() throws ImageReadException {
        Object o = getValue();

        if (o instanceof Number)
            return new int[]{((Number) o).intValue()};
        else if (o instanceof Number[]) {
            Number numbers[] = (Number[]) o;
            int result[] = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++)
                result[i] = numbers[i].intValue();
            return result;
        } else if (o instanceof short[]) {
            short numbers[] = (short[]) o;
            int result[] = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++)
                result[i] = 0xffff & numbers[i];
            return result;
        } else if (o instanceof int[]) {
            int numbers[] = (int[]) o;
            int result[] = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++)
                result[i] = numbers[i];
            return result;
        }

        throw new ImageReadException("Unknown value: " + o + " for: " + tagInfo.getDescription());
    }

    public double[] getDoubleArrayValue() throws ImageReadException {
        Object o = getValue();

        if (o instanceof Number) {
            return new double[]{((Number) o).doubleValue()};
        } else if (o instanceof Number[]) {
            Number numbers[] = (Number[]) o;
            double result[] = new double[numbers.length];
            for (int i = 0; i < numbers.length; i++)
                result[i] = numbers[i].doubleValue();
            return result;
        } else if (o instanceof short[]) {
            short numbers[] = (short[]) o;
            double result[] = new double[numbers.length];
            for (int i = 0; i < numbers.length; i++)
                result[i] = numbers[i];
            return result;
        } else if (o instanceof int[]) {
            int numbers[] = (int[]) o;
            double result[] = new double[numbers.length];
            for (int i = 0; i < numbers.length; i++)
                result[i] = numbers[i];
            return result;
        } else if (o instanceof float[]) {
            float numbers[] = (float[]) o;
            double result[] = new double[numbers.length];
            for (int i = 0; i < numbers.length; i++)
                result[i] = numbers[i];
            return result;
        } else if (o instanceof double[]) {
            double numbers[] = (double[]) o;
            double result[] = new double[numbers.length];
            for (int i = 0; i < numbers.length; i++)
                result[i] = numbers[i];
            return result;
        }

        throw new ImageReadException("Unknown value: " + o + " for: "
                + tagInfo.getDescription());
        // return null;
    }

    public int getIntValueOrArraySum() throws ImageReadException {
        Object o = getValue();
        // if (o == null)
        // return -1;

        if (o instanceof Number)
            return ((Number) o).intValue();
        else if (o instanceof Number[]) {
            Number numbers[] = (Number[]) o;
            int sum = 0;
            for (int i = 0; i < numbers.length; i++)
                sum += numbers[i].intValue();
            return sum;
        } else if (o instanceof short[]) {
            short[] numbers = (short[]) o;
            int sum = 0;
            for (int i = 0; i < numbers.length; i++)
                sum += numbers[i];
            return sum;
        } else if (o instanceof int[]) {
            int numbers[] = (int[]) o;
            int sum = 0;
            for (int i = 0; i < numbers.length; i++)
                sum += numbers[i];
            return sum;
        }

        throw new ImageReadException("Unknown value: " + o + " for: " + tagInfo.getDescription());
    }

    public int getIntValue() throws ImageReadException {
        Object o = getValue();
        if (o == null)
            throw new ImageReadException("Missing value: "
                    + tagInfo.getDescription());

        return ((Number) o).intValue();
    }

    public double getDoubleValue() throws ImageReadException {
        Object o = getValue();
        if (o == null)
            throw new ImageReadException("Missing value: "
                    + tagInfo.getDescription());

        return ((Number) o).doubleValue();
    }

    public byte[] getByteArrayValue() {
        return fieldType.getRawBytes(this);
    }

    public int getSortHint() {
        return sortHint;
    }

    public void setSortHint(int sortHint) {
        this.sortHint = sortHint;
    }
}
