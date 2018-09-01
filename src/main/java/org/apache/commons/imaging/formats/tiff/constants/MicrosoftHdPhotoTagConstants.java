package org.apache.commons.imaging.formats.tiff.constants;

import org.apache.commons.imaging.common.BinaryConstant;
import org.apache.commons.imaging.formats.tiff.taginfos.*;

import java.util.List;

/**
 * Microsoft's HDP/WDP file format.
 */
public interface MicrosoftHdPhotoTagConstants extends TiffFieldTypeConstants {
    /*
     * The byte order for this GUID field is as follows:
     * Data1 (int), Data2 (short), Data3 (short) are little-endian,
     * Data4 (char[8]) is endian-independent.
     */
    TagInfoByte EXIF_TAG_PIXEL_FORMAT = new TagInfoByte(
            "Pixel Format", 0xbc01, 16,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoLong EXIF_TAG_TRANSFOMATION = new TagInfoLong(
            "Transfomation", 0xbc02, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    TagInfoLong EXIF_TAG_UNCOMPRESSED = new TagInfoLong(
            "Uncompressed", 0xbc03, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    TagInfoLong EXIF_TAG_IMAGE_TYPE = new TagInfoLong("Image Type",
            0xbc04, 1, TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoLong EXIF_TAG_IMAGE_WIDTH = new TagInfoLong(
            "Image Width", 0xbc80, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoLong EXIF_TAG_IMAGE_HEIGHT = new TagInfoLong(
            "Image Height", 0xbc81, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoFloat EXIF_TAG_WIDTH_RESOLUTION = new TagInfoFloat(
            "Width Resolution", 0xbc82, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoFloat EXIF_TAG_HEIGHT_RESOLUTION = new TagInfoFloat(
            "Height Resolution", 0xbc83, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    // FIXME: might be an offset?
    TagInfoLong EXIF_TAG_IMAGE_OFFSET = new TagInfoLong(
            "Image Offset", 0xbcc0, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoLong EXIF_TAG_IMAGE_BYTE_COUNT = new TagInfoLong(
            "Image Byte Count", 0xbcc1, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    // FIXME: might be an offset?
    TagInfoLong EXIF_TAG_ALPHA_OFFSET = new TagInfoLong(
            "Alpha Offset", 0xbcc2, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoLong EXIF_TAG_ALPHA_BYTE_COUNT = new TagInfoLong(
            "Alpha Byte Count", 0xbcc3, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoByte EXIF_TAG_IMAGE_DATA_DISCARD = new TagInfoByte(
            "Image Data Discard", 0xbcc4, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoByte EXIF_TAG_ALPHA_DATA_DISCARD = new TagInfoByte(
            "Alpha Data Discard", 0xbcc5, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoUndefined EXIF_TAG_PADDING = new TagInfoUndefined(
            "Padding", 0xea1c, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    List<TagInfo> ALL_MICROSOFT_HD_PHOTO_TAGS =
            List.of(EXIF_TAG_PIXEL_FORMAT,
                    EXIF_TAG_TRANSFOMATION,
                    EXIF_TAG_UNCOMPRESSED,
                    EXIF_TAG_IMAGE_TYPE,
                    EXIF_TAG_IMAGE_WIDTH,
                    EXIF_TAG_IMAGE_HEIGHT,
                    EXIF_TAG_WIDTH_RESOLUTION,
                    EXIF_TAG_HEIGHT_RESOLUTION,
                    EXIF_TAG_IMAGE_OFFSET,
                    EXIF_TAG_IMAGE_BYTE_COUNT,
                    EXIF_TAG_ALPHA_OFFSET,
                    EXIF_TAG_ALPHA_BYTE_COUNT,
                    EXIF_TAG_IMAGE_DATA_DISCARD,
                    EXIF_TAG_ALPHA_DATA_DISCARD,
                    EXIF_TAG_PADDING);
}
