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
package org.apache.commons.imaging.formats.tiff.constants;

import org.apache.commons.imaging.SanselanConstants;
import org.apache.commons.imaging.formats.tiff.fieldtypes.*;

import java.util.List;

public interface TiffFieldTypeConstants extends SanselanConstants {

    FieldTypeByte FIELD_TYPE_BYTE = new FieldTypeByte(1,
            "Byte");

    FieldTypeAscii FIELD_TYPE_ASCII = new FieldTypeAscii(2,
            "ASCII");

    FieldTypeShort FIELD_TYPE_SHORT = new FieldTypeShort(3,
            "Short");

    FieldTypeLong FIELD_TYPE_LONG = new FieldTypeLong(4,
            "Long");

    FieldTypeRational FIELD_TYPE_RATIONAL = new FieldTypeRational(
            5, "Rational");

    FieldType FIELD_TYPE_SBYTE = new FieldTypeByte(6,
            "SByte");
    FieldType FIELD_TYPE_UNDEFINED = new FieldTypeByte(7,
            "Undefined");
    FieldType FIELD_TYPE_SSHORT = new FieldTypeShort(8,
            "SShort");

    FieldType FIELD_TYPE_SLONG = new FieldTypeLong(9,
            "SLong");

    FieldType FIELD_TYPE_SRATIONAL = new FieldTypeRational(
            10, "SRational");

    FieldType FIELD_TYPE_FLOAT = new FieldTypeFloat();

    FieldType FIELD_TYPE_DOUBLE = new FieldTypeDouble();

    FieldType FIELD_TYPE_UNKNOWN = new FieldTypeUnknown();

    List<FieldType> FIELD_TYPES =
            List.of(FIELD_TYPE_BYTE, FIELD_TYPE_ASCII, FIELD_TYPE_SHORT,
                    FIELD_TYPE_LONG, FIELD_TYPE_RATIONAL, FIELD_TYPE_SBYTE,
                    FIELD_TYPE_UNDEFINED, FIELD_TYPE_SSHORT, FIELD_TYPE_SLONG,
                    FIELD_TYPE_SRATIONAL, FIELD_TYPE_FLOAT, FIELD_TYPE_DOUBLE);

    List<FieldType> FIELD_TYPE_ANY = FIELD_TYPES;

    List<FieldType> FIELD_TYPE_DESCRIPTION_SHORT_OR_LONG = List.of(FIELD_TYPE_SHORT, FIELD_TYPE_LONG);

    List<FieldType> FIELD_TYPE_DESCRIPTION_SHORT_OR_RATIONAL = List.of(FIELD_TYPE_SHORT, FIELD_TYPE_RATIONAL);

    List<FieldType> FIELD_TYPE_DESCRIPTION_BYTE_OR_SHORT = List.of(FIELD_TYPE_SHORT, FIELD_TYPE_BYTE);

    List<FieldType> FIELD_TYPE_DESCRIPTION_ASCII_OR_RATIONAL = List.of(FIELD_TYPE_ASCII, FIELD_TYPE_RATIONAL);

    List<FieldType> FIELD_TYPE_DESCRIPTION_ASCII_OR_BYTE = List.of(FIELD_TYPE_ASCII, FIELD_TYPE_BYTE);
}