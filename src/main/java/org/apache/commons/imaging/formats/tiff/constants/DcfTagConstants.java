package org.apache.commons.imaging.formats.tiff.constants;

import org.apache.commons.imaging.formats.tiff.taginfos.TagInfo;
import org.apache.commons.imaging.formats.tiff.taginfos.TagInfoAscii;
import org.apache.commons.imaging.formats.tiff.taginfos.TagInfoShort;
import org.apache.commons.imaging.formats.tiff.taginfos.TagInfoShortOrLong;

import java.util.List;

/**
 * Design rule for Camera Filesystem
 * <BR>
 * http://www.exif.org/dcf.PDF
 */
public interface DcfTagConstants extends TiffFieldTypeConstants {
    TagInfoAscii EXIF_TAG_RELATED_IMAGE_FILE_FORMAT = new TagInfoAscii(
            "Related Image File Format", 0x1000, -1,
            TiffDirectoryType.EXIF_DIRECTORY_INTEROP_IFD);

    TagInfoShortOrLong EXIF_TAG_RELATED_IMAGE_WIDTH = new TagInfoShortOrLong(
            "Related Image Width", 0x1001, 1,
            TiffDirectoryType.EXIF_DIRECTORY_INTEROP_IFD);

    TagInfoShortOrLong EXIF_TAG_RELATED_IMAGE_LENGTH = new TagInfoShortOrLong(
            "Related Image Length", 0x1002, 1,
            TiffDirectoryType.EXIF_DIRECTORY_INTEROP_IFD);

    TagInfoShort EXIF_TAG_COLOR_SPACE = new TagInfoShort(
            "Color Space", 0xa001, 1, TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD);

    List<TagInfo> ALL_DCF_TAGS =
            List.of(EXIF_TAG_RELATED_IMAGE_FILE_FORMAT,
                    EXIF_TAG_RELATED_IMAGE_WIDTH,
                    EXIF_TAG_RELATED_IMAGE_LENGTH,
                    EXIF_TAG_COLOR_SPACE);
}
