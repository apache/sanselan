package org.apache.commons.imaging.formats.tiff.constants;

import org.apache.commons.imaging.formats.tiff.taginfos.*;

import java.util.List;

/**
 *
 */
public interface TiffEpTagConstants extends TiffFieldTypeConstants {
    TagInfoShort EXIF_TAG_CFAREPEAT_PATTERN_DIM = new TagInfoShort(
            "CFARepeat Pattern Dim", 0x828d, 2,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoByte EXIF_TAG_CFAPATTERN_2 = new TagInfoByte(
            "CFAPattern 2", 0x828e, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoAsciiOrRational EXIF_TAG_BATTERY_LEVEL = new TagInfoAsciiOrRational(
            "Battery Level", 0x828f, -1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    TagInfoUndefined EXIF_TAG_ICC_PROFILE = new TagInfoUndefined(
            "ICC_Profile", 0x8773, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoShort EXIF_TAG_INTERLACE = new TagInfoShort(
            "Interlace", 0x8829, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoSShort EXIF_TAG_TIME_ZONE_OFFSET = new TagInfoSShort(
            "Time Zone Offset", 0x882a, -1,
            TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD);

    TagInfoShort EXIF_TAG_SELF_TIMER_MODE = new TagInfoShort(
            "Self Timer Mode", 0x882b, 1,
            TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD);

    TagInfoRational EXIF_TAG_FLASH_ENERGY = new TagInfoRational(
            "Flash Energy", 0x920b, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoUndefined EXIF_TAG_SPATIAL_FREQUENCY_RESPONSE_1 = new TagInfoUndefined(
            "Spatial Frequency Response", 0x920c, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoUndefined EXIF_TAG_NOISE_1 = new TagInfoUndefined(
            "Noise", 0x920d, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoRational EXIF_TAG_FOCAL_PLANE_XRESOLUTION = new TagInfoRational(
            "Focal Plane XResolution", 0x920e, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoRational EXIF_TAG_FOCAL_PLANE_YRESOLUTION = new TagInfoRational(
            "Focal Plane YResolution", 0x920f, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoShort EXIF_TAG_FOCAL_PLANE_RESOLUTION_UNIT = new TagInfoShort(
            "Focal Plane Resolution Unit", 0x9210, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    int FOCAL_PLANE_RESOLUTION_UNIT_VALUE_NONE = 1;
    int FOCAL_PLANE_RESOLUTION_UNIT_VALUE_INCHES = 2;
    int FOCAL_PLANE_RESOLUTION_UNIT_VALUE_CM = 3;
    int FOCAL_PLANE_RESOLUTION_UNIT_VALUE_MM = 4;
    int FOCAL_PLANE_RESOLUTION_UNIT_VALUE_UM = 5;

    TagInfoLong EXIF_TAG_IMAGE_NUMBER_EXIF_IFD = new TagInfoLong(
            "Image Number", 0x9211, 1,
            TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD);

    TagInfoAscii EXIF_TAG_SECURITY_CLASSIFICATION_EXIF_IFD = new TagInfoAscii(
            "Security Classification", 0x9212, -1,
            TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD);

    TagInfoAscii EXIF_TAG_IMAGE_HISTORY_EXIF_IFD = new TagInfoAscii(
            "Image History", 0x9213, -1,
            TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD);

    TagInfoRational EXIF_TAG_EXPOSURE_INDEX = new TagInfoRational(
            "Exposure Index", 0x9215, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoByte EXIF_TAG_TIFF_EPSTANDARD_ID_1 = new TagInfoByte(
            "TIFF/EP Standard ID", 0x9216, 4,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoShort EXIF_TAG_SENSING_METHOD = new TagInfoShort(
            "Sensing Method", 0x9217, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    List<TagInfo> ALL_TIFF_EP_TAGS =
            List.of(EXIF_TAG_CFAREPEAT_PATTERN_DIM,
                    EXIF_TAG_CFAPATTERN_2,
                    EXIF_TAG_BATTERY_LEVEL,
                    EXIF_TAG_ICC_PROFILE,
                    EXIF_TAG_INTERLACE,
                    EXIF_TAG_TIME_ZONE_OFFSET,
                    EXIF_TAG_SELF_TIMER_MODE,
                    EXIF_TAG_FLASH_ENERGY,
                    EXIF_TAG_SPATIAL_FREQUENCY_RESPONSE_1,
                    EXIF_TAG_NOISE_1,
                    EXIF_TAG_FOCAL_PLANE_XRESOLUTION,
                    EXIF_TAG_FOCAL_PLANE_YRESOLUTION,
                    EXIF_TAG_FOCAL_PLANE_RESOLUTION_UNIT,
                    EXIF_TAG_IMAGE_NUMBER_EXIF_IFD,
                    EXIF_TAG_SECURITY_CLASSIFICATION_EXIF_IFD,
                    EXIF_TAG_IMAGE_HISTORY_EXIF_IFD,
                    EXIF_TAG_EXPOSURE_INDEX,
                    EXIF_TAG_TIFF_EPSTANDARD_ID_1,
                    EXIF_TAG_SENSING_METHOD);
}
