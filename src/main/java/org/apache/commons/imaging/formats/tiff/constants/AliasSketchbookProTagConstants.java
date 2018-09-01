package org.apache.commons.imaging.formats.tiff.constants;

import org.apache.commons.imaging.formats.tiff.taginfos.TagInfo;
import org.apache.commons.imaging.formats.tiff.taginfos.TagInfoAscii;

import java.util.List;

/**
 * Alias Sketchbook Pro multi-layer TIFF
 * <BR>
 * http://www.awaresystems.be/imaging/tiff/tifftags/docs/alias.html
 */
public interface AliasSketchbookProTagConstants extends TiffFieldTypeConstants {
    TagInfoAscii EXIF_TAG_ALIAS_LAYER_METADATA = new TagInfoAscii(
            "Alias Layer Metadata", 0xc660, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    List<TagInfo> ALL_ALIAS_SKETCHBOOK_PRO_TAGS =
            List.of(EXIF_TAG_ALIAS_LAYER_METADATA);
}
