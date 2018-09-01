package org.apache.commons.imaging.formats.tiff.constants;

import org.apache.commons.imaging.formats.tiff.taginfos.*;

import java.util.List;

/**
 * RFC 2301: File Format for Internet Fax
 * <BR>
 * www.ietf.org/rfc/rfc2301.txt
 * <BR>
 * Also subsumes  "The spirit of TIFF class F"
 * <BR>
 * http://cool.conservation-us.org/bytopic/imaging/std/tiff-f.html
 */
public interface Rfc2301TagConstants extends TiffFieldTypeConstants {
    TagInfoShortOrLong TIFF_TAG_BAD_FAX_LINES = new TagInfoShortOrLong(
            "Bad Fax Lines", 0x0146, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoShort TIFF_TAG_CLEAN_FAX_DATA = new TagInfoShort(
            "Clean Fax Data", 0x0147, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    int CLEAN_FAX_DATA_VALUE_CLEAN = 0;
    int CLEAN_FAX_DATA_VALUE_REGENERATED = 1;
    int CLEAN_FAX_DATA_VALUE_UNCLEAN = 2;

    TagInfoShortOrLong TIFF_TAG_CONSECUTIVE_BAD_FAX_LINES = new TagInfoShortOrLong(
            "Consecutive Bad Fax Lines", 0x0148, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoLong TIFF_TAG_GLOBAL_PARAMETERS_IFD = new TagInfoLong(
            "Global Parameters IFD", 0x0190, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN, true);

    TagInfoLong TIFF_TAG_PROFILE_TYPE = new TagInfoLong(
            "Profile Type", 0x0191, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    int PROFILE_TYPE_VALUE_UNSPECIFIED = 0;
    int PROFILE_TYPE_VALUE_GROUP_3_FAX = 1;

    TagInfoByte TIFF_TAG_FAX_PROFILE = new TagInfoByte(
            "Fax Profile", 0x0192, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    int FAX_PROFILE_VALUE_UNKNOWN = 0;
    int FAX_PROFILE_VALUE_MINIMAL_B_AND_W_LOSSLESS_S = 1;
    int FAX_PROFILE_VALUE_EXTENDED_B_AND_W_LOSSLESS_F = 2;
    int FAX_PROFILE_VALUE_LOSSLESS_JBIG_B_AND_W_J = 3;
    int FAX_PROFILE_VALUE_LOSSY_COLOR_AND_GRAYSCALE_C = 4;
    int FAX_PROFILE_VALUE_LOSSLESS_COLOR_AND_GRAYSCALE_L = 5;
    int FAX_PROFILE_VALUE_MIXED_RASTER_CONTENT_M = 6;

    TagInfoLong TIFF_TAG_CODING_METHODS = new TagInfoLong(
            "Coding Methods", 0x0193, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoByte TIFF_TAG_VERSION_YEAR = new TagInfoByte(
            "Version Year", 0x0194, 4,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoByte TIFF_TAG_MODE_NUMBER = new TagInfoByte(
            "Mode Number", 0x0195, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoRational TIFF_TAG_DECODE = new TagInfoRational(
            "Decode", 0x01b1, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoShort TIFF_TAG_DEFAULT_IMAGE_COLOR = new TagInfoShort(
            "Default Image Color", 0x01b2, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoLong TIFF_TAG_STRIP_ROW_COUNTS = new TagInfoLong(
            "Strip Row Counts", 0x022f, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoShortOrLong TIFF_TAG_IMAGE_LAYER = new TagInfoShortOrLong(
            "Image Layer", 0x87ac, 2,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    List<TagInfo> ALL_RFC_2301_TAGS =
            List.of(
                    TIFF_TAG_BAD_FAX_LINES,
                    TIFF_TAG_CLEAN_FAX_DATA,
                    TIFF_TAG_CONSECUTIVE_BAD_FAX_LINES,
                    TIFF_TAG_GLOBAL_PARAMETERS_IFD,
                    TIFF_TAG_PROFILE_TYPE,
                    TIFF_TAG_FAX_PROFILE,
                    TIFF_TAG_CODING_METHODS,
                    TIFF_TAG_VERSION_YEAR,
                    TIFF_TAG_MODE_NUMBER,
                    TIFF_TAG_DECODE,
                    TIFF_TAG_DEFAULT_IMAGE_COLOR,
                    TIFF_TAG_STRIP_ROW_COUNTS,
                    TIFF_TAG_IMAGE_LAYER);
}
