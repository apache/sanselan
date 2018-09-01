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
package org.apache.commons.imaging.formats.jpeg;

import org.apache.commons.imaging.common.BinaryConstant;

public interface JpegConstants
{
    int MAX_SEGMENT_SIZE = 0xffff;

    BinaryConstant JFIF0_SIGNATURE = new BinaryConstant(new byte[] {
            0x4a, // J
            0x46, // F
            0x49, // I
            0x46, // F
            0x0, //
    });
    BinaryConstant JFIF0_SIGNATURE_ALTERNATIVE = new BinaryConstant(new byte[] {
            0x4a, // J
            0x46, // F
            0x49, // I
            0x46, // F
            0x20, //
    });

    BinaryConstant EXIF_IDENTIFIER_CODE = new BinaryConstant(new byte[] {
            0x45, // E
            0x78, // x
            0x69, // i
            0x66, // f
    });

    BinaryConstant XMP_IDENTIFIER = new BinaryConstant(new byte[] {
            0x68, // h
            0x74, // t
            0x74, // t
            0x70, // p
            0x3A, // :
            0x2F, // /
            0x2F, // /
            0x6E, // n
            0x73, // s
            0x2E, // .
            0x61, // a
            0x64, // d
            0x6F, // o
            0x62, // b
            0x65, // e
            0x2E, // .
            0x63, // c
            0x6F, // o
            0x6D, // m
            0x2F, // /
            0x78, // x
            0x61, // a
            0x70, // p
            0x2F, // /
            0x31, // 1
            0x2E, // .
            0x30, // 0
            0x2F, // /
            0, // 0-terminated us-ascii string.
    });

    BinaryConstant SOI = new BinaryConstant(new byte[] { (byte) 0xff, (byte) 0xd8 });
    BinaryConstant EOI = new BinaryConstant(new byte[] { (byte) 0xff, (byte) 0xd9 });

    int JPEG_APP0 = 0xE0;
    int JPEG_APP0_Marker = (0xff00) | (JPEG_APP0);
    int JPEG_APP1_Marker = (0xff00) | (JPEG_APP0 + 1);
    int JPEG_APP2_Marker = (0xff00) | (JPEG_APP0 + 2);
    int JPEG_APP13_Marker = (0xff00) | (JPEG_APP0 + 13);
    int JPEG_APP14_Marker = (0xff00) | (JPEG_APP0 + 14);
    int JPEG_APP15_Marker = (0xff00) | (JPEG_APP0 + 15);

    int JFIFMarker = 0xFFE0;
    int SOF0Marker = 0xFFc0;
    int SOF1Marker = 0xFFc0 + 0x1;
    int SOF2Marker = 0xFFc0 + 0x2;
    int SOF3Marker = 0xFFc0 + 0x3;
    int DHTMarker = 0xFFc0 + 0x4;
    int SOF5Marker = 0xFFc0 + 0x5;
    int SOF6Marker = 0xFFc0 + 0x6;
    int SOF7Marker = 0xFFc0 + 0x7;
    int SOF8Marker = 0xFFc0 + 0x8;
    int SOF9Marker = 0xFFc0 + 0x9;
    int SOF10Marker = 0xFFc0 + 0xa;
    int SOF11Marker = 0xFFc0 + 0xb;
    int DACMarker = 0xFFc0 + 0xc;
    int SOF13Marker = 0xFFc0 + 0xd;
    int SOF14Marker = 0xFFc0 + 0xe;
    int SOF15Marker = 0xFFc0 + 0xf;

    int EOIMarker = 0xFFd9;
    int SOS_Marker = 0xFFda;
    int DQTMarker = 0xFFdb;
    int DNLMarker = 0xFFdc;
    int COMMarker = 0xFFfe;

    BinaryConstant icc_profile_label = new BinaryConstant(new byte[] {
            0x49, 0x43, 0x43, 0x5F,
            0x50, 0x52, 0x4F, 0x46,
            0x49, 0x4C, 0x45, 0x0
    });

    BinaryConstant PHOTOSHOP_IDENTIFICATION_STRING = new BinaryConstant(new byte[] {
            0x50, // P
            0x68, // h
            0x6F, // o
            0x74, // t
            0x6F, // o
            0x73, // s
            0x68, // h
            0x6F, // o
            0x70, // p
            0x20, //
            0x33, // 3
            0x2E, // .
            0x30, // 0
            0,
    });
    BinaryConstant CONST_8BIM = new BinaryConstant(new byte[] {
            0x38, // 8
            0x42, // B
            0x49, // I
            0x4D, // M
    });
}
