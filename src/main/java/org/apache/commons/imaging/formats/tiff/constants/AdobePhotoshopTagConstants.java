package org.apache.commons.imaging.formats.tiff.constants;

import org.apache.commons.imaging.formats.tiff.taginfos.TagInfo;
import org.apache.commons.imaging.formats.tiff.taginfos.TagInfoUndefined;

import java.util.List;

/**
 * TIFF specification supplement 2
 * <BR>
 * Adobe Photoshop (R) TIFF Technical Notes
 * <BR>
 * http://partners.adobe.com/public/developer/en/tiff/TIFFphotoshop.pdf
 */
public interface AdobePhotoshopTagConstants {
    TagInfoUndefined EXIF_TAG_JPEGTABLES = new TagInfoUndefined(
            "JPEGTables", 0x015b, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoUndefined EXIF_TAG_IMAGE_SOURCE_DATA = new TagInfoUndefined(
            "Image Source Data", 0x935c, 1,
            TiffDirectoryType.EXIF_DIRECTORY_IFD0);

    List<TagInfo> ALL_ADOBE_PHOTOSHOP_TAGS =
            List.of(
                    EXIF_TAG_JPEGTABLES,
                    EXIF_TAG_IMAGE_SOURCE_DATA
            );
}
