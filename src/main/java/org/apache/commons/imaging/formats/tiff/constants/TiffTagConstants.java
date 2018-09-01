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

import org.apache.commons.imaging.formats.tiff.taginfos.*;

import java.util.List;

/**
 * Tags from the TIFF6 specification.
 * <BR>
 * http://partners.adobe.com/public/developer/en/tiff/TIFF6.pdf
 */
public interface TiffTagConstants
        extends
        TiffFieldTypeConstants {
    TagInfoLong TIFF_TAG_NEW_SUBFILE_TYPE = new TagInfoLong(
            "New Subfile Type", 0xFE, 1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoShort TIFF_TAG_SUBFILE_TYPE = new TagInfoShort(
            "Subfile Type", 0xFF, 1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoShortOrLong TIFF_TAG_IMAGE_WIDTH = new TagInfoShortOrLong(
            "Image Width", 0x100, 1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoShortOrLong TIFF_TAG_IMAGE_LENGTH = new TagInfoShortOrLong(
            "Image Length", 0x101, 1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoShort TIFF_TAG_BITS_PER_SAMPLE = new TagInfoShort(
            "Bits Per Sample", 0x102, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoShort TIFF_TAG_COMPRESSION = new TagInfoShort(
            "Compression", 0x103, 1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);
    int COMPRESSION_VALUE_UNCOMPRESSED = 1;
    int COMPRESSION_VALUE_CCITT_1D = 2;
    int COMPRESSION_VALUE_T4_GROUP_3_FAX = 3;
    int COMPRESSION_VALUE_T6_GROUP_4_FAX = 4;
    int COMPRESSION_VALUE_LZW = 5;
    int COMPRESSION_VALUE_JPEG_OLD_STYLE = 6;
    int COMPRESSION_VALUE_JPEG = 7;
    int COMPRESSION_VALUE_ADOBE_DEFLATE = 8;
    int COMPRESSION_VALUE_JBIG_B_AND_W = 9;
    int COMPRESSION_VALUE_JBIG_COLOR = 10;
    int COMPRESSION_VALUE_NEXT = 32766;
    int COMPRESSION_VALUE_EPSON_ERF_COMPRESSED = 32769;
    int COMPRESSION_VALUE_CCIRLEW = 32771;
    int COMPRESSION_VALUE_PACK_BITS = 32773;
    int COMPRESSION_VALUE_THUNDERSCAN = 32809;
    int COMPRESSION_VALUE_IT8CTPAD = 32895;
    int COMPRESSION_VALUE_IT8LW = 32896;
    int COMPRESSION_VALUE_IT8MP = 32897;
    int COMPRESSION_VALUE_IT8BL = 32898;
    int COMPRESSION_VALUE_PIXAR_FILM = 32908;
    int COMPRESSION_VALUE_PIXAR_LOG = 32909;
    int COMPRESSION_VALUE_DEFLATE = 32946;
    int COMPRESSION_VALUE_DCS = 32947;
    int COMPRESSION_VALUE_JBIG = 34661;
    int COMPRESSION_VALUE_SGILOG = 34676;
    int COMPRESSION_VALUE_SGILOG_24 = 34677;
    int COMPRESSION_VALUE_JPEG_2000 = 34712;
    int COMPRESSION_VALUE_NIKON_NEF_COMPRESSED = 34713;
    int COMPRESSION_VALUE_KODAK_DCR_COMPRESSED = 65000;
    int COMPRESSION_VALUE_PENTAX_PEF_COMPRESSED = 65535;

    TagInfoShort TIFF_TAG_PHOTOMETRIC_INTERPRETATION = new TagInfoShort(
            "Photometric Interpretation", 0x106, 1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);
    int PHOTOMETRIC_INTERPRETATION_VALUE_WHITE_IS_ZERO = 0;
    int PHOTOMETRIC_INTERPRETATION_VALUE_BLACK_IS_ZERO = 1;
    int PHOTOMETRIC_INTERPRETATION_VALUE_RGB = 2;
    int PHOTOMETRIC_INTERPRETATION_VALUE_RGB_PALETTE = 3;
    int PHOTOMETRIC_INTERPRETATION_VALUE_TRANSPARENCY_MASK = 4;
    int PHOTOMETRIC_INTERPRETATION_VALUE_CMYK = 5;
    int PHOTOMETRIC_INTERPRETATION_VALUE_YCB_CR = 6;
    int PHOTOMETRIC_INTERPRETATION_VALUE_CIELAB = 8;
    int PHOTOMETRIC_INTERPRETATION_VALUE_ICCLAB = 9;
    int PHOTOMETRIC_INTERPRETATION_VALUE_ITULAB = 10;
    int PHOTOMETRIC_INTERPRETATION_VALUE_COLOR_FILTER_ARRAY = 32803;
    int PHOTOMETRIC_INTERPRETATION_VALUE_PIXAR_LOG_L = 32844;
    int PHOTOMETRIC_INTERPRETATION_VALUE_PIXAR_LOG_LUV = 32845;
    int PHOTOMETRIC_INTERPRETATION_VALUE_LINEAR_RAW = 34892;

    TagInfoShort TIFF_TAG_THRESHHOLDING = new TagInfoShort(
            "Threshholding", 0x107, 1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);
    int THRESHOLDING_VALUE_NO_DITHERING_OR_HALFTONING = 1;
    int THRESHOLDING_VALUE_ORDERED_DITHER_OR_HALFTONE = 2;
    int THRESHOLDING_VALUE_RANDOMIZED_DITHER = 3;

    TagInfoShort TIFF_TAG_CELL_WIDTH = new TagInfoShort(
            "Cell Width", 0x108, 1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoShort TIFF_TAG_CELL_LENGTH = new TagInfoShort(
            "Cell Length", 0x109, 1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoShort TIFF_TAG_FILL_ORDER = new TagInfoShort(
            "Fill Order", 0x10A, 1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);
    int FILL_ORDER_VALUE_NORMAL = 1;
    int FILL_ORDER_VALUE_REVERSED = 2;

    TagInfoAscii TIFF_TAG_DOCUMENT_NAME = new TagInfoAscii(
            "Document Name", 0x10D, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoAscii TIFF_TAG_IMAGE_DESCRIPTION = new TagInfoAscii(
            "Image Description", 0x10E, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoAscii TIFF_TAG_MAKE = new TagInfoAscii(
            "Make", 0x10F, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoAscii TIFF_TAG_MODEL = new TagInfoAscii(
            "Model", 0x110, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoShortOrLong TIFF_TAG_STRIP_OFFSETS = new TagInfoShortOrLong(
            "Strip Offsets", 0x111, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT, true);

    TagInfoShort TIFF_TAG_ORIENTATION = new TagInfoShort(
            "Orientation", 0x112, 1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);
    int ORIENTATION_VALUE_HORIZONTAL_NORMAL = 1;
    int ORIENTATION_VALUE_MIRROR_HORIZONTAL = 2;
    int ORIENTATION_VALUE_ROTATE_180 = 3;
    int ORIENTATION_VALUE_MIRROR_VERTICAL = 4;
    int ORIENTATION_VALUE_MIRROR_HORIZONTAL_AND_ROTATE_270_CW = 5;
    int ORIENTATION_VALUE_ROTATE_90_CW = 6;
    int ORIENTATION_VALUE_MIRROR_HORIZONTAL_AND_ROTATE_90_CW = 7;
    int ORIENTATION_VALUE_ROTATE_270_CW = 8;

    TagInfoShort TIFF_TAG_SAMPLES_PER_PIXEL = new TagInfoShort(
            "Samples Per Pixel", 0x115, 1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoShortOrLong TIFF_TAG_ROWS_PER_STRIP = new TagInfoShortOrLong(
            "Rows Per Strip", 0x116, 1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoShortOrLong TIFF_TAG_STRIP_BYTE_COUNTS = new TagInfoShortOrLong(
            "Strip Byte Counts", 0x117, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoShort TIFF_TAG_MIN_SAMPLE_VALUE = new TagInfoShort(
            "Min Sample Value", 0x118, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoShort TIFF_TAG_MAX_SAMPLE_VALUE = new TagInfoShort(
            "Max Sample Value", 0x119, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoRational TIFF_TAG_XRESOLUTION = new TagInfoRational(
            "XResolution", 0x11A, 1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoRational TIFF_TAG_YRESOLUTION = new TagInfoRational(
            "YResolution", 0x11B, 1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoShort TIFF_TAG_PLANAR_CONFIGURATION = new TagInfoShort(
            "Planar Configuration", 0x11C, 1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);
    int PLANAR_CONFIGURATION_VALUE_CHUNKY = 1;
    int PLANAR_CONFIGURATION_VALUE_PLANAR = 2;

    TagInfoAscii TIFF_TAG_PAGE_NAME = new TagInfoAscii(
            "Page Name", 0x11D, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoRational TIFF_TAG_XPOSITION = new TagInfoRational(
            "XPosition", 0x11E, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoRational TIFF_TAG_YPOSITION = new TagInfoRational(
            "YPosition", 0x11F, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoLong TIFF_TAG_FREE_OFFSETS = new TagInfoLong(
            "Free Offsets", 0x120, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoLong TIFF_TAG_FREE_BYTE_COUNTS = new TagInfoLong(
            "Free Byte Counts", 0x121, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoShort TIFF_TAG_GRAY_RESPONSE_UNIT = new TagInfoShort(
            "Gray Response Unit", 0x122, 1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);
    int GRAY_RESPONSE_UNIT_VALUE_0_1 = 1;
    int GRAY_RESPONSE_UNIT_VALUE_0_01 = 2;
    int GRAY_RESPONSE_UNIT_VALUE_0_001 = 3;
    int GRAY_RESPONSE_UNIT_VALUE_0_0001 = 4;
    int GRAY_RESPONSE_UNIT_VALUE_0_00001 = 5;

    TagInfoShort TIFF_TAG_GRAY_RESPONSE_CURVE = new TagInfoShort(
            "Gray Response Curve", 0x123, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoLong TIFF_TAG_T4_OPTIONS = new TagInfoLong(
            "T4 Options", 0x124, 1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoLong TIFF_TAG_T6_OPTIONS = new TagInfoLong(
            "T6 Options", 0x125, 1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoShort TIFF_TAG_RESOLUTION_UNIT = new TagInfoShort(
            "Resolution Unit", 0x128, 1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);
    int RESOLUTION_UNIT_VALUE_NONE = 1;
    int RESOLUTION_UNIT_VALUE_INCHES = 2;
    int RESOLUTION_UNIT_VALUE_CM = 3;

    TagInfoShort TIFF_TAG_PAGE_NUMBER = new TagInfoShort(
            "Page Number", 0x129, 2,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoShort TIFF_TAG_TRANSFER_FUNCTION = new TagInfoShort(
            "Transfer Function", 0x12D, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoAscii TIFF_TAG_SOFTWARE = new TagInfoAscii(
            "Software", 0x131, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoAscii TIFF_TAG_DATE_TIME = new TagInfoAscii(
            "Date Time", 0x132, 20,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoAscii TIFF_TAG_ARTIST = new TagInfoAscii(
            "Artist", 0x13B, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoAscii TIFF_TAG_HOST_COMPUTER = new TagInfoAscii(
            "Host Computer", 0x13C, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoShort TIFF_TAG_PREDICTOR = new TagInfoShort(
            "Predictor", 0x13D, 1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);
    int PREDICTOR_VALUE_NONE = 1;
    int PREDICTOR_VALUE_HORIZONTAL_DIFFERENCING = 2;

    TagInfoRational TIFF_TAG_WHITE_POINT = new TagInfoRational(
            "White Point", 0x13E, 2,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoRational TIFF_TAG_PRIMARY_CHROMATICITIES = new TagInfoRational(
            "Primary Chromaticities", 0x13F, 6,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoShort TIFF_TAG_COLOR_MAP = new TagInfoShort(
            "Color Map", 0x140, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoShort TIFF_TAG_HALFTONE_HINTS = new TagInfoShort(
            "Halftone Hints", 0x141, 2,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoShortOrLong TIFF_TAG_TILE_WIDTH = new TagInfoShortOrLong(
            "Tile Width", 0x142, 1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoShortOrLong TIFF_TAG_TILE_LENGTH = new TagInfoShortOrLong(
            "Tile Length", 0x143, 1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoLong TIFF_TAG_TILE_OFFSETS = new TagInfoLong(
            "Tile Offsets", 0x144, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT, true);

    TagInfoShortOrLong TIFF_TAG_TILE_BYTE_COUNTS = new TagInfoShortOrLong(
            "Tile Byte Counts", 0x145, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoShort TIFF_TAG_INK_SET = new TagInfoShort(
            "Ink Set", 0x14C, 1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);
    int INK_SET_VALUE_CMYK = 1;
    int INK_SET_VALUE_NOT_CMYK = 2;

    TagInfoAscii TIFF_TAG_INK_NAMES = new TagInfoAscii(
            "Ink Names", 0x14D, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoShort TIFF_TAG_NUMBER_OF_INKS = new TagInfoShort(
            "Number Of Inks", 0x14E, 1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoByteOrShort TIFF_TAG_DOT_RANGE = new TagInfoByteOrShort(
            "Dot Range", 0x150, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoAscii TIFF_TAG_TARGET_PRINTER = new TagInfoAscii(
            "Target Printer", 0x151, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoShort TIFF_TAG_EXTRA_SAMPLES = new TagInfoShort(
            "Extra Samples", 0x152, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoShort TIFF_TAG_SAMPLE_FORMAT = new TagInfoShort(
            "Sample Format", 0x153, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);
    int SAMPLE_FORMAT_VALUE_UNSIGNED_INTEGER = 1;
    int SAMPLE_FORMAT_VALUE_TWOS_COMPLEMENT_SIGNED_INTEGER = 2;
    int SAMPLE_FORMAT_VALUE_IEEE_FLOATING_POINT = 3;
    int SAMPLE_FORMAT_VALUE_UNDEFINED = 4;
    int SAMPLE_FORMAT_VALUE_COMPLEX_INTEGER = 5;
    int SAMPLE_FORMAT_VALUE_IEEE_FLOATING_POINT_1 = 6;

    TagInfoAny TIFF_TAG_SMIN_SAMPLE_VALUE = new TagInfoAny(
            "SMin Sample Value", 0x154, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoAny TIFF_TAG_SMAX_SAMPLE_VALUE = new TagInfoAny(
            "SMax Sample Value", 0x155, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoShort TIFF_TAG_TRANSFER_RANGE = new TagInfoShort(
            "Transfer Range", 0x156, 6,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoShort TIFF_TAG_JPEG_PROC = new TagInfoShort(
            "JPEGProc", 0x200, 1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);
    int JPEGPROC_VALUE_BASELINE = 1;
    int JPEGPROC_VALUE_LOSSLESS = 14;

    TagInfoLong TIFF_TAG_JPEG_INTERCHANGE_FORMAT = new TagInfoLong(
            "JPEGInterchange Format", 0x201, 1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT, true);

    TagInfoLong TIFF_TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = new TagInfoLong(
            "JPEGInterchange Format Length", 0x202,
            1, TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoShort TIFF_TAG_JPEG_RESTART_INTERVAL = new TagInfoShort(
            "JPEGRestart Interval", 0x203, 1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoShort TIFF_TAG_JPEG_LOSSLESS_PREDICTORS = new TagInfoShort(
            "JPEGLossless Predictors", 0x205, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoShort TIFF_TAG_JPEG_POINT_TRANSFORMS = new TagInfoShort(
            "JPEGPoint Transforms", 0x206, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoLong TIFF_TAG_JPEG_QTABLES = new TagInfoLong(
            "JPEGQTables", 0x207, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoLong TIFF_TAG_JPEG_DCTABLES = new TagInfoLong(
            "JPEGDCTables", 0x208, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoLong TIFF_TAG_JPEG_ACTABLES = new TagInfoLong(
            "JPEGACTables", 0x209, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoRational TIFF_TAG_YCBCR_COEFFICIENTS = new TagInfoRational(
            "YCbCr Coefficients", 0x211, 3,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoShort TIFF_TAG_YCBCR_SUB_SAMPLING = new TagInfoShort(
            "YCbCr Sub Sampling", 0x212, 2,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoShort TIFF_TAG_YCBCR_POSITIONING = new TagInfoShort(
            "YCbCr Positioning", 0x213, 1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoLong TIFF_TAG_REFERENCE_BLACK_WHITE = new TagInfoLong(
            "Reference Black White", 0x214, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoAscii TIFF_TAG_COPYRIGHT = new TagInfoAscii(
            "Copyright", 0x8298, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoByte TIFF_TAG_XMP = new TagInfoByte(
            "XMP", 0x2BC, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    // TODO:
    //    TagInfo2 TIFF_TAG_UNKNOWN = null;
    TagInfo TIFF_TAG_UNKNOWN = new TagInfoUnknown(
            "Unknown Tag", -1, TagInfo.LENGTH_UNKNOWN,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    List<TagInfo> ALL_TIFF_TAGS =
            List.of(TIFF_TAG_NEW_SUBFILE_TYPE, TIFF_TAG_SUBFILE_TYPE,
                    TIFF_TAG_IMAGE_WIDTH, TIFF_TAG_IMAGE_LENGTH,
                    TIFF_TAG_BITS_PER_SAMPLE, TIFF_TAG_COMPRESSION,
                    TIFF_TAG_PHOTOMETRIC_INTERPRETATION, TIFF_TAG_THRESHHOLDING,
                    TIFF_TAG_CELL_WIDTH, TIFF_TAG_CELL_LENGTH, TIFF_TAG_FILL_ORDER,
                    TIFF_TAG_DOCUMENT_NAME, TIFF_TAG_IMAGE_DESCRIPTION, TIFF_TAG_MAKE,
                    TIFF_TAG_MODEL, TIFF_TAG_STRIP_OFFSETS, TIFF_TAG_ORIENTATION,
                    TIFF_TAG_SAMPLES_PER_PIXEL, TIFF_TAG_ROWS_PER_STRIP,
                    TIFF_TAG_STRIP_BYTE_COUNTS, TIFF_TAG_MIN_SAMPLE_VALUE,
                    TIFF_TAG_MAX_SAMPLE_VALUE, TIFF_TAG_XRESOLUTION,
                    TIFF_TAG_YRESOLUTION, TIFF_TAG_PLANAR_CONFIGURATION,
                    TIFF_TAG_PAGE_NAME, TIFF_TAG_XPOSITION, TIFF_TAG_YPOSITION,
                    TIFF_TAG_FREE_OFFSETS, TIFF_TAG_FREE_BYTE_COUNTS,
                    TIFF_TAG_GRAY_RESPONSE_UNIT, TIFF_TAG_GRAY_RESPONSE_CURVE,
                    TIFF_TAG_T4_OPTIONS, TIFF_TAG_T6_OPTIONS, TIFF_TAG_RESOLUTION_UNIT,
                    TIFF_TAG_PAGE_NUMBER, TIFF_TAG_TRANSFER_FUNCTION,
                    TIFF_TAG_SOFTWARE, TIFF_TAG_DATE_TIME, TIFF_TAG_ARTIST,
                    TIFF_TAG_HOST_COMPUTER, TIFF_TAG_PREDICTOR, TIFF_TAG_WHITE_POINT,
                    TIFF_TAG_PRIMARY_CHROMATICITIES, TIFF_TAG_COLOR_MAP,
                    TIFF_TAG_HALFTONE_HINTS, TIFF_TAG_TILE_WIDTH, TIFF_TAG_TILE_LENGTH,
                    TIFF_TAG_TILE_OFFSETS, TIFF_TAG_TILE_BYTE_COUNTS, TIFF_TAG_INK_SET,
                    TIFF_TAG_INK_NAMES, TIFF_TAG_NUMBER_OF_INKS, TIFF_TAG_DOT_RANGE,
                    TIFF_TAG_TARGET_PRINTER, TIFF_TAG_EXTRA_SAMPLES,
                    TIFF_TAG_SAMPLE_FORMAT, TIFF_TAG_SMIN_SAMPLE_VALUE,
                    TIFF_TAG_SMAX_SAMPLE_VALUE, TIFF_TAG_TRANSFER_RANGE,
                    TIFF_TAG_JPEG_PROC, TIFF_TAG_JPEG_INTERCHANGE_FORMAT,
                    TIFF_TAG_JPEG_INTERCHANGE_FORMAT_LENGTH,
                    TIFF_TAG_JPEG_RESTART_INTERVAL, TIFF_TAG_JPEG_LOSSLESS_PREDICTORS,
                    TIFF_TAG_JPEG_POINT_TRANSFORMS, TIFF_TAG_JPEG_QTABLES,
                    TIFF_TAG_JPEG_DCTABLES, TIFF_TAG_JPEG_ACTABLES,
                    TIFF_TAG_YCBCR_COEFFICIENTS, TIFF_TAG_YCBCR_SUB_SAMPLING,
                    TIFF_TAG_YCBCR_POSITIONING, TIFF_TAG_REFERENCE_BLACK_WHITE,
                    TIFF_TAG_COPYRIGHT,
                    TIFF_TAG_XMP);
}