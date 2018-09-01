package org.apache.commons.imaging.formats.tiff.constants;

import org.apache.commons.imaging.formats.tiff.taginfos.TagInfo;
import org.apache.commons.imaging.formats.tiff.taginfos.TagInfoAscii;

import java.util.List;

/**
 * GDAL library.
 * <BR>
 * http://www.awaresystems.be/imaging/tiff/tifftags/gdal_metadata.html
 * <BR>
 * http://www.awaresystems.be/imaging/tiff/tifftags/gdal_nodata.html
 */
public interface GdalLibraryTagConstants {
    TagInfoAscii EXIF_TAG_GDALMETADATA = new TagInfoAscii(
            "GDALMetadata", 0xa480, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    
    TagInfoAscii EXIF_TAG_GDALNO_DATA = new TagInfoAscii(
            "GDALNo Data", 0xa481, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    List<TagInfo> ALL_GDAL_LIBRARY_TAGS =
            List.of(EXIF_TAG_GDALMETADATA,
                    EXIF_TAG_GDALNO_DATA);
}
