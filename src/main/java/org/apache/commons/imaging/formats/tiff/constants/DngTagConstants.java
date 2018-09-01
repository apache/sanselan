package org.apache.commons.imaging.formats.tiff.constants;

import org.apache.commons.imaging.formats.tiff.taginfos.*;

import java.util.List;

/**
 * Digital Negative (DNG) Specification
 * <BR>
 * http://www.adobe.com/products/dng/pdfs/dng_spec_1_3_0_0.pdf
 */
public interface DngTagConstants extends TiffFieldTypeConstants {
    TagInfoByte EXIF_TAG_DNG_VERSION = new TagInfoByte(
            "DNG Version", 0xc612, 4,
            TiffDirectoryType.EXIF_DIRECTORY_IFD0);
    
    TagInfoByte EXIF_TAG_DNG_BACKWARD_VERSION = new TagInfoByte(
            "DNG Backward Version", 0xc613, 4,
            TiffDirectoryType.EXIF_DIRECTORY_IFD0);

    TagInfoAscii EXIF_TAG_UNIQUE_CAMERA_MODEL = new TagInfoAscii(
            "Unique Camera Model", 0xc614, -1,
            TiffDirectoryType.EXIF_DIRECTORY_IFD0);

    TagInfoAsciiOrByte EXIF_TAG_LOCALIZED_CAMERA_MODEL = new TagInfoAsciiOrByte(
            "Localized Camera Model", 0xc615, -1,
            TiffDirectoryType.EXIF_DIRECTORY_IFD0);

    TagInfoByte EXIF_TAG_CFAPLANE_COLOR = new TagInfoByte(
            "CFAPlane Color", 0xc616, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoShort EXIF_TAG_CFALAYOUT = new TagInfoShort(
            "CFALayout", 0xc617, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    int CFALAYOUT_VALUE_RECTANGULAR = 1;
    int CFALAYOUT_VALUE_EVEN_COLUMNS_OFFSET_DOWN_1_2_ROW = 2;
    int CFALAYOUT_VALUE_EVEN_COLUMNS_OFFSET_UP_1_2_ROW = 3;
    int CFALAYOUT_VALUE_EVEN_ROWS_OFFSET_RIGHT_1_2_COLUMN = 4;
    int CFALAYOUT_VALUE_EVEN_ROWS_OFFSET_LEFT_1_2_COLUMN = 5;
    int CFALAYOUT_VALUE_EVEN_ROWS_OFFSET_UP_1_2_ROW_EVEN_COLUMNS_OFFSET_LEFT_1_2_COLUMN = 6;
    int CFALAYOUT_VALUE_EVEN_ROWS_OFFSET_UP_1_2_ROW_EVEN_COLUMNS_OFFSET_RIGHT_1_2_COLUMN = 7;
    int CFALAYOUT_VALUE_EVEN_ROWS_OFFSET_DOWN_1_2_ROW_EVEN_COLUMNS_OFFSET_LEFT_1_2_COLUMN = 8;
    int CFALAYOUT_VALUE_EVEN_ROWS_OFFSET_DOWN_1_2_ROW_EVEN_COLUMNS_OFFSET_RIGHT_1_2_COLUMN = 9;
    
    TagInfoShort EXIF_TAG_LINEARIZATION_TABLE = new TagInfoShort(
            "Linearization Table", 0xc618, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoShort EXIF_TAG_BLACK_LEVEL_REPEAT_DIM = new TagInfoShort(
            "Black Level Repeat Dim", 0xc619,
            2, TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoShortOrLongOrRational EXIF_TAG_BLACK_LEVEL = new TagInfoShortOrLongOrRational(
            "Black Level", 0xc61a, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoSRational EXIF_TAG_BLACK_LEVEL_DELTA_H = new TagInfoSRational(
            "Black Level Delta H", 0xc61b, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoSRational EXIF_TAG_BLACK_LEVEL_DELTA_V = new TagInfoSRational(
            "Black Level Delta V", 0xc61c, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoShortOrLong EXIF_TAG_WHITE_LEVEL = new TagInfoShortOrLong(
            "White Level", 0xc61d, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoRational EXIF_TAG_DEFAULT_SCALE = new TagInfoRational(
            "Default Scale", 0xc61e, 2,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoShortOrLongOrRational EXIF_TAG_DEFAULT_CROP_ORIGIN = new TagInfoShortOrLongOrRational(
            "Default Crop Origin", 0xc61f, 2,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoShortOrLongOrRational EXIF_TAG_DEFAULT_CROP_SIZE = new TagInfoShortOrLongOrRational(
            "Default Crop Size", 0xc620, 2,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoSRational EXIF_TAG_COLOR_MATRIX_1 = new TagInfoSRational(
            "Color Matrix 1", 0xc621, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoSRational EXIF_TAG_COLOR_MATRIX_2 = new TagInfoSRational(
            "Color Matrix 2", 0xc622, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoSRational EXIF_TAG_CAMERA_CALIBRATION_1 = new TagInfoSRational(
            "Camera Calibration 1", 0xc623, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoSRational EXIF_TAG_CAMERA_CALIBRATION_2 = new TagInfoSRational(
            "Camera Calibration 2", 0xc624, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoSRational EXIF_TAG_REDUCTION_MATRIX_1 = new TagInfoSRational(
            "Reduction Matrix 1", 0xc625, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoSRational EXIF_TAG_REDUCTION_MATRIX_2 = new TagInfoSRational(
            "Reduction Matrix 2", 0xc626, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoRational EXIF_TAG_ANALOG_BALANCE = new TagInfoRational(
            "Analog Balance", 0xc627, -1,
            TiffDirectoryType.EXIF_DIRECTORY_IFD0);

    TagInfoShortOrRational EXIF_TAG_AS_SHOT_NEUTRAL = new TagInfoShortOrRational(
            "As Shot Neutral", 0xc628, -1,
            TiffDirectoryType.EXIF_DIRECTORY_IFD0);

    TagInfoRational EXIF_TAG_AS_SHOT_WHITE_XY = new TagInfoRational(
            "As Shot White XY", 0xc629, 2,
            TiffDirectoryType.EXIF_DIRECTORY_IFD0);

    TagInfoSRational EXIF_TAG_BASELINE_EXPOSURE = new TagInfoSRational(
            "Baseline Exposure", 0xc62a, 1,
            TiffDirectoryType.EXIF_DIRECTORY_IFD0);

    TagInfoRational EXIF_TAG_BASELINE_NOISE = new TagInfoRational(
            "Baseline Noise", 0xc62b, 1,
            TiffDirectoryType.EXIF_DIRECTORY_IFD0);

    TagInfoRational EXIF_TAG_BASELINE_SHARPNESS = new TagInfoRational(
            "Baseline Sharpness", 0xc62c, 1,
            TiffDirectoryType.EXIF_DIRECTORY_IFD0);

    TagInfoLong EXIF_TAG_BAYER_GREEN_SPLIT = new TagInfoLong(
            "Bayer Green Split", 0xc62d, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoRational EXIF_TAG_LINEAR_RESPONSE_LIMIT = new TagInfoRational(
            "Linear Response Limit", 0xc62e, 1,
            TiffDirectoryType.EXIF_DIRECTORY_IFD0);

    TagInfoAscii EXIF_TAG_CAMERA_SERIAL_NUMBER = new TagInfoAscii(
            "Camera Serial Number", 0xc62f, -1,
            TiffDirectoryType.EXIF_DIRECTORY_IFD0);

    TagInfoRational EXIF_TAG_DNG_LENS_INFO = new TagInfoRational(
            "DNG Lens Info", 0xc630, 4,
            TiffDirectoryType.EXIF_DIRECTORY_IFD0);
    
    TagInfoRational EXIF_TAG_CHROMA_BLUR_RADIUS = new TagInfoRational(
            "Chroma Blur Radius", 0xc631, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoRational EXIF_TAG_ANTI_ALIAS_STRENGTH = new TagInfoRational(
            "Anti Alias Strength", 0xc632, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoRational EXIF_TAG_SHADOW_SCALE = new TagInfoRational(
            "Shadow Scale", 0xc633, 1,
            TiffDirectoryType.EXIF_DIRECTORY_IFD0);

    TagInfoByte EXIF_TAG_DNG_PRIVATE_DATA = new TagInfoByte(
            "DNG Private Data", 0xc634, -1,
            TiffDirectoryType.EXIF_DIRECTORY_IFD0);

    TagInfoShort EXIF_TAG_MAKER_NOTE_SAFETY = new TagInfoShort(
            "Maker Note Safety", 0xc635, 1,
            TiffDirectoryType.EXIF_DIRECTORY_IFD0);
    int MAKER_NOTE_SAFETY_VALUE_UNSAFE = 0;
    int MAKER_NOTE_SAFETY_VALUE_SAFE = 1;

    TagInfoShort EXIF_TAG_CALIBRATION_ILLUMINANT_1 = new TagInfoShort(
            "Calibration Illuminant 1", 0xc65a, 1,
            TiffDirectoryType.EXIF_DIRECTORY_IFD0);

    TagInfoShort EXIF_TAG_CALIBRATION_ILLUMINANT_2 = new TagInfoShort(
            "Calibration Illuminant 2", 0xc65b, 1,
            TiffDirectoryType.EXIF_DIRECTORY_IFD0);

    TagInfoRational EXIF_TAG_BEST_QUALITY_SCALE = new TagInfoRational(
            "Best Quality Scale", 0xc65c, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    
    TagInfoByte EXIF_TAG_RAW_DATA_UNIQUE_ID = new TagInfoByte(
            "Raw Data Unique ID", 0xc65d, 16,
            TiffDirectoryType.EXIF_DIRECTORY_IFD0);

    TagInfoAsciiOrByte EXIF_TAG_ORIGINAL_RAW_FILE_NAME = new TagInfoAsciiOrByte(
            "Original Raw File Name", 0xc68b, -1,
            TiffDirectoryType.EXIF_DIRECTORY_IFD0);

    TagInfoUndefined EXIF_TAG_ORIGINAL_RAW_FILE_DATA = new TagInfoUndefined(
            "Original Raw File Data", 0xc68c, -1,
            TiffDirectoryType.EXIF_DIRECTORY_IFD0);

    TagInfoShortOrLong EXIF_TAG_ACTIVE_AREA = new TagInfoShortOrLong(
            "Active Area", 0xc68d, 4,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoShortOrLong EXIF_TAG_MASKED_AREAS = new TagInfoShortOrLong(
            "Masked Areas", 0xc68e, 4,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoUndefined EXIF_TAG_AS_SHOT_ICCPROFILE = new TagInfoUndefined(
            "As Shot ICCProfile", 0xc68f, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoSRational EXIF_TAG_AS_SHOT_PRE_PROFILE_MATRIX = new TagInfoSRational(
            "As Shot Pre Profile Matrix", 0xc690, -1,
            TiffDirectoryType.EXIF_DIRECTORY_IFD0);

    TagInfoUndefined EXIF_TAG_CURRENT_ICCPROFILE = new TagInfoUndefined(
            "Current ICCProfile", 0xc691, -1,
            TiffDirectoryType.EXIF_DIRECTORY_IFD0);

    TagInfoSRational EXIF_TAG_CURRENT_PRE_PROFILE_MATRIX = new TagInfoSRational(
            "Current Pre Profile Matrix", 0xc692, -1,
            TiffDirectoryType.EXIF_DIRECTORY_IFD0);

    TagInfoShort EXIF_TAG_COLORIMETRIC_REFERENCE = new TagInfoShort(
            "Colorimetric Reference", 0xc6bf, 1,
            TiffDirectoryType.EXIF_DIRECTORY_IFD0);
    short COLORIMETRIC_REFERENCE_VALUE_SCENE_REFERRED = 0;
    short COLORIMETRIC_REFERENCE_VALUE_OUTPUT_REFERRED = 1;
    
    TagInfoAsciiOrByte EXIF_TAG_CAMERA_CALIBRATION_SIGNATURE = new TagInfoAsciiOrByte(
            "Camera Calibration Signature", 0xc6f3, -1,
            TiffDirectoryType.EXIF_DIRECTORY_IFD0);
    
    TagInfoAsciiOrByte EXIF_TAG_PROFILE_CALIBRATION_SIGNATURE = new TagInfoAsciiOrByte(
            "Profile Calibration Signature", 0xc6f4, -1,
            TiffDirectoryType.EXIF_DIRECTORY_IFD0);
    
    TagInfoLong EXIF_TAG_EXTRA_CAMERA_PROFILES = new TagInfoLong(
            "Extra Camera Profiles", 0xc6f5, -1,
            TiffDirectoryType.EXIF_DIRECTORY_IFD0);
    
    TagInfoAsciiOrByte EXIF_TAG_AS_SHOT_PROFILE_NAME = new TagInfoAsciiOrByte(
            "As Shot Profile Name", 0xc6f6, -1,
            TiffDirectoryType.EXIF_DIRECTORY_IFD0);
    
    TagInfoRational EXIF_TAG_NOISE_REDUCTION_APPLIED = new TagInfoRational(
            "Noise Reduction Applied", 0xc6f7, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    
    TagInfoAscii EXIF_TAG_PROFILE_NAME = new TagInfoAscii(
            "Profile Name", 0xc6f8, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    
    TagInfoLong EXIF_TAG_PROFILE_HUE_SAT_MAP_DIMS = new TagInfoLong(
            "Profile Hue/Sat/Map", 0xc6f9, 3,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    
    TagInfoFloat EXIF_TAG_PROFILE_HUE_SAT_MAP_DATA1 = new TagInfoFloat(
            "Profile Hue/Sat/Map Data1", 0xc6fa, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    
    TagInfoFloat EXIF_TAG_PROFILE_HUE_SAT_MAP_DATA2 = new TagInfoFloat(
            "Profile Hue/Sat/Map Data2", 0xc6fb, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    
    TagInfoFloat EXIF_TAG_PROFILE_TONE_CURVE = new TagInfoFloat(
            "Profile Tone Curve", 0xc6fc, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    
    TagInfoLong EXIF_TAG_PROFILE_EMBED_POLICY = new TagInfoLong(
            "Profile Embed Policy", 0xc6fd, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    
    TagInfoAsciiOrByte EXIF_TAG_PROFILE_COPYRIGHT = new TagInfoAsciiOrByte(
            "Profile Copyright", 0xc6fe, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    
    TagInfoSRational EXIF_TAG_FORWARD_MATRIX1 = new TagInfoSRational(
            "Forward Matrix 1", 0xc714, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    
    TagInfoSRational EXIF_TAG_FORWARD_MATRIX2 = new TagInfoSRational(
            "Forward Matrix 2", 0xc715, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    
    TagInfoAsciiOrByte EXIF_TAG_PREVIEW_APPLICATION_NAME = new TagInfoAsciiOrByte(
            "Preview Application Name", 0xc716, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    
    TagInfoAsciiOrByte EXIF_TAG_PREVIEW_APPLICATION_VERSION = new TagInfoAsciiOrByte(
            "Preview Application Version", 0xc717, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoAsciiOrByte EXIF_TAG_PREVIEW_SETTINGS_NAME = new TagInfoAsciiOrByte(
            "Preview Settings Name", 0xc718, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoByte EXIF_TAG_PREVIEW_SETTINGS_DIGEST = new TagInfoByte(
            "Preview Settings Digest", 0xc719, 16,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    
    TagInfoLong EXIF_TAG_PREVIEW_COLORSPACE = new TagInfoLong(
            "Preview Colorspace", 0xc71a, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    
    TagInfoAscii EXIF_TAG_PREVIEW_DATE_TIME = new TagInfoAscii(
            "Preview DateTime", 0xc71b, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    
    TagInfoByte EXIF_TAG_RAW_IMAGE_DIGEST = new TagInfoByte(
            "Raw Image Digest", 0xc71c, 16,
            TiffDirectoryType.EXIF_DIRECTORY_IFD0);
    
    TagInfoByte EXIF_TAG_ORIGINAL_RAW_FILE_DIGEST = new TagInfoByte(
            "Original Raw File Digest", 0xc71d, 16,
            TiffDirectoryType.EXIF_DIRECTORY_IFD0);
    
    TagInfoShortOrLong EXIF_TAG_SUB_TILE_BLOCK_SIZE = new TagInfoShortOrLong(
            "Sub Tile Block Size", 0xc71e, 2,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    
    TagInfoShortOrLong EXIF_TAG_ROW_INTERLEAVE_FACTOR = new TagInfoShortOrLong(
            "Row Interleave Factor", 0xc71f, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    
    TagInfoLong EXIF_TAG_PROFILE_LOOK_TABLE_DIMS = new TagInfoLong(
            "Profile Look Table Dims", 0xc725, 3,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    
    TagInfoFloat EXIF_TAG_PROFILE_LOOK_TABLE_DATA = new TagInfoFloat(
            "Profile Look Table Data", 0xc726, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    
    TagInfoUndefined EXIF_TAG_OPCODE_LIST_1 = new TagInfoUndefined(
            "Opcode List 1", 0xc740, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    
    TagInfoUndefined EXIF_TAG_OPCODE_LIST_2 = new TagInfoUndefined(
            "Opcode List 2", 0xc741, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoUndefined EXIF_TAG_OPCODE_LIST_3 = new TagInfoUndefined(
            "Opcode List 3", 0xc74E, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    
    TagInfoDouble EXIF_TAG_NOISE_PROFILE = new TagInfoDouble(
            "Noise Profile", 0xc761, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    List<TagInfo> ALL_DNG_TAGS =
            List.of(EXIF_TAG_DNG_VERSION,
                    EXIF_TAG_DNG_BACKWARD_VERSION,
                    EXIF_TAG_UNIQUE_CAMERA_MODEL,
                    EXIF_TAG_LOCALIZED_CAMERA_MODEL,
                    EXIF_TAG_CFAPLANE_COLOR,
                    EXIF_TAG_CFALAYOUT,
                    EXIF_TAG_LINEARIZATION_TABLE,
                    EXIF_TAG_BLACK_LEVEL_REPEAT_DIM,
                    EXIF_TAG_BLACK_LEVEL,
                    EXIF_TAG_BLACK_LEVEL_DELTA_H,
                    EXIF_TAG_BLACK_LEVEL_DELTA_V,
                    EXIF_TAG_WHITE_LEVEL,
                    EXIF_TAG_DEFAULT_SCALE,
                    EXIF_TAG_DEFAULT_CROP_ORIGIN,
                    EXIF_TAG_DEFAULT_CROP_SIZE,
                    EXIF_TAG_COLOR_MATRIX_1,
                    EXIF_TAG_COLOR_MATRIX_2,
                    EXIF_TAG_CAMERA_CALIBRATION_1,
                    EXIF_TAG_CAMERA_CALIBRATION_2,
                    EXIF_TAG_REDUCTION_MATRIX_1,
                    EXIF_TAG_REDUCTION_MATRIX_2,
                    EXIF_TAG_ANALOG_BALANCE,
                    EXIF_TAG_AS_SHOT_NEUTRAL,
                    EXIF_TAG_AS_SHOT_WHITE_XY,
                    EXIF_TAG_BASELINE_EXPOSURE,
                    EXIF_TAG_BASELINE_NOISE,
                    EXIF_TAG_BASELINE_SHARPNESS,
                    EXIF_TAG_BAYER_GREEN_SPLIT,
                    EXIF_TAG_LINEAR_RESPONSE_LIMIT,
                    EXIF_TAG_CAMERA_SERIAL_NUMBER,
                    EXIF_TAG_DNG_LENS_INFO,
                    EXIF_TAG_CHROMA_BLUR_RADIUS,
                    EXIF_TAG_ANTI_ALIAS_STRENGTH,
                    EXIF_TAG_SHADOW_SCALE,
                    EXIF_TAG_DNG_PRIVATE_DATA,
                    EXIF_TAG_MAKER_NOTE_SAFETY,
                    EXIF_TAG_CALIBRATION_ILLUMINANT_1,
                    EXIF_TAG_CALIBRATION_ILLUMINANT_2,
                    EXIF_TAG_BEST_QUALITY_SCALE,
                    EXIF_TAG_RAW_DATA_UNIQUE_ID,
                    EXIF_TAG_ORIGINAL_RAW_FILE_NAME,
                    EXIF_TAG_ORIGINAL_RAW_FILE_DATA,
                    EXIF_TAG_ACTIVE_AREA,
                    EXIF_TAG_MASKED_AREAS,
                    EXIF_TAG_AS_SHOT_ICCPROFILE,
                    EXIF_TAG_AS_SHOT_PRE_PROFILE_MATRIX,
                    EXIF_TAG_CURRENT_ICCPROFILE,
                    EXIF_TAG_CURRENT_PRE_PROFILE_MATRIX,
                    EXIF_TAG_COLORIMETRIC_REFERENCE,
                    EXIF_TAG_CAMERA_CALIBRATION_SIGNATURE,
                    EXIF_TAG_PROFILE_CALIBRATION_SIGNATURE,
                    EXIF_TAG_EXTRA_CAMERA_PROFILES,
                    EXIF_TAG_AS_SHOT_PROFILE_NAME,
                    EXIF_TAG_NOISE_REDUCTION_APPLIED,
                    EXIF_TAG_PROFILE_NAME,
                    EXIF_TAG_PROFILE_HUE_SAT_MAP_DIMS,
                    EXIF_TAG_PROFILE_HUE_SAT_MAP_DATA1,
                    EXIF_TAG_PROFILE_HUE_SAT_MAP_DATA2,
                    EXIF_TAG_PROFILE_TONE_CURVE,
                    EXIF_TAG_PROFILE_EMBED_POLICY,
                    EXIF_TAG_PROFILE_COPYRIGHT,
                    EXIF_TAG_FORWARD_MATRIX1,
                    EXIF_TAG_FORWARD_MATRIX2,
                    EXIF_TAG_PREVIEW_APPLICATION_NAME,
                    EXIF_TAG_PREVIEW_APPLICATION_VERSION,
                    EXIF_TAG_PREVIEW_SETTINGS_NAME,
                    EXIF_TAG_PREVIEW_SETTINGS_DIGEST,
                    EXIF_TAG_PREVIEW_COLORSPACE,
                    EXIF_TAG_PREVIEW_DATE_TIME,
                    EXIF_TAG_RAW_IMAGE_DIGEST,
                    EXIF_TAG_ORIGINAL_RAW_FILE_DIGEST,
                    EXIF_TAG_SUB_TILE_BLOCK_SIZE,
                    EXIF_TAG_ROW_INTERLEAVE_FACTOR,
                    EXIF_TAG_PROFILE_LOOK_TABLE_DIMS,
                    EXIF_TAG_PROFILE_LOOK_TABLE_DATA,
                    EXIF_TAG_OPCODE_LIST_1,
                    EXIF_TAG_OPCODE_LIST_2,
                    EXIF_TAG_OPCODE_LIST_3,
                    EXIF_TAG_NOISE_PROFILE);
}
