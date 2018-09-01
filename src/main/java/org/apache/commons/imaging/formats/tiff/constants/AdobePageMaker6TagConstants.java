package org.apache.commons.imaging.formats.tiff.constants;

import org.apache.commons.imaging.formats.tiff.taginfos.*;

import java.util.List;

/**
 * TIFF specification supplement 1
 * <BR>
 * Enhancements for Adobe PageMaker(R) 6.0 software
 * <BR>
 * http://partners.adobe.com/public/developer/en/tiff/TIFFPM6.pdf
 */
public interface AdobePageMaker6TagConstants extends TiffFieldTypeConstants {
    TagInfoLong TIFF_TAG_SUB_IFD = new TagInfoLong(
            "Sub IFD",  0x014a, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN, true);

    TagInfoByte TIFF_TAG_CLIP_PATH = new TagInfoByte(
            "Clip Path",  0x0157, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    
    TagInfoLong TIFF_TAG_XCLIP_PATH_UNITS = new TagInfoLong(
            "XClip Path Units", 0x0158, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    
    TagInfoLong TIFF_TAG_YCLIP_PATH_UNITS = new TagInfoLong(
            "YClip Path Units", 0x0159, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoShort TIFF_TAG_INDEXED = new TagInfoShort(
            "Indexed", 0x015a, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoShort TIFF_TAG_OPIPROXY = new TagInfoShort(
            "OPIProxy", 0x015f, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoAscii TIFF_TAG_IMAGE_ID = new TagInfoAscii(
            "Image ID", 0x800d, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    
    List<TagInfo> ALL_ADOBE_PAGEMAKER_6_TAGS =
            List.of(TIFF_TAG_SUB_IFD,
                    TIFF_TAG_CLIP_PATH,
                    TIFF_TAG_XCLIP_PATH_UNITS,
                    TIFF_TAG_YCLIP_PATH_UNITS,
                    TIFF_TAG_INDEXED,
                    TIFF_TAG_OPIPROXY,
                    TIFF_TAG_IMAGE_ID);
}
