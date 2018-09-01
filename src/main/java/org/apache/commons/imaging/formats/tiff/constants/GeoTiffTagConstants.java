package org.apache.commons.imaging.formats.tiff.constants;

import org.apache.commons.imaging.formats.tiff.taginfos.TagInfo;
import org.apache.commons.imaging.formats.tiff.taginfos.TagInfoAscii;
import org.apache.commons.imaging.formats.tiff.taginfos.TagInfoDouble;
import org.apache.commons.imaging.formats.tiff.taginfos.TagInfoShort;

import java.util.List;

/**
 * Geo Tiff.
 * <BR>
 * http://www.remotesensing.org/geotiff/spec/contents.html
 */
public interface GeoTiffTagConstants {
    TagInfoDouble EXIF_TAG_MODEL_PIXEL_SCALE = new TagInfoDouble(
            "Model Pixel Scale", 0x830e, 3,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoDouble EXIF_TAG_INTERGRAPH_MATRIX = new TagInfoDouble(
            "Intergraph Matrix", 0x8480, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoDouble EXIF_TAG_MODEL_TIE_POINT = new TagInfoDouble(
            "Model Tie Point", 0x8482, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    
    TagInfoDouble EXIF_TAG_MODEL_TRANSFORMATION = new TagInfoDouble(
            "Model Transformation", 0x85d8, 16,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoShort EXIF_TAG_GEO_TIFF_DIRECTORY = new TagInfoShort(
            "Geo Tiff Directory", 0x87af, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    
    TagInfoDouble EXIF_TAG_GEO_TIFF_DOUBLE_PARAMS = new TagInfoDouble(
            "Geo Tiff Double Params", 0x87b0, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    
    TagInfoAscii EXIF_TAG_GEO_TIFF_ASCII_PARAMS = new TagInfoAscii(
            "Geo Tiff Ascii Params", 0x87b1, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);
    
    List<TagInfo> ALL_GEO_TIFF_TAGS =
            List.of(EXIF_TAG_MODEL_PIXEL_SCALE,
                    EXIF_TAG_INTERGRAPH_MATRIX,
                    EXIF_TAG_MODEL_TIE_POINT,
                    EXIF_TAG_MODEL_TRANSFORMATION,
                    EXIF_TAG_GEO_TIFF_DIRECTORY,
                    EXIF_TAG_GEO_TIFF_DOUBLE_PARAMS,
                    EXIF_TAG_GEO_TIFF_ASCII_PARAMS);

}
