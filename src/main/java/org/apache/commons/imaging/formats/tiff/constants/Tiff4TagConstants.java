package org.apache.commons.imaging.formats.tiff.constants;

import org.apache.commons.imaging.formats.tiff.taginfos.TagInfo;
import org.apache.commons.imaging.formats.tiff.taginfos.TagInfoShort;

import java.util.List;

/**
 * Tags in TIFF4 but NOT in TIFF6.
 * <BR>
 * http://cool.conservation-us.org/bytopic/imaging/std/tiff4.html
 */
public interface Tiff4TagConstants {
    TagInfoShort TIFF_TAG_COLOR_RESPONSE_UNIT = new TagInfoShort(
            "Color Response Unit", 0x12C, 1,
            TiffDirectoryType.TIFF_DIRECTORY_ROOT);

    List<TagInfo> ALL_TIFF_4_TAGS =
            List.of(TIFF_TAG_COLOR_RESPONSE_UNIT);
}
