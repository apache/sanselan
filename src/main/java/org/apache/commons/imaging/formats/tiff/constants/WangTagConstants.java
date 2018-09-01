package org.apache.commons.imaging.formats.tiff.constants;

import org.apache.commons.imaging.formats.tiff.taginfos.TagInfo;
import org.apache.commons.imaging.formats.tiff.taginfos.TagInfoByte;

import java.util.List;

/**
 * Wang/Eastman Software/Kodac/eiStream/Imaging for Windows tags,
 * undocumented and in need of more work.
 */
public interface WangTagConstants {
    TagInfoByte EXIF_TAG_WANG_ANNOTATION = new TagInfoByte(
            "Wang Annotation", 0x80a4, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    List<TagInfo> ALL_WANG_TAGS =
            List.of(EXIF_TAG_WANG_ANNOTATION);
}
