package org.apache.commons.imaging.formats.tiff.constants;

import org.apache.commons.imaging.formats.tiff.taginfos.*;

import java.util.List;

/**
 * Molecular Dynamics GEL file format
 * <BR>
 * http://www.awaresystems.be/imaging/tiff/tifftags/docs/gel.html
 */
public interface MolecularDynamicsGelTagConstants extends TiffFieldTypeConstants {
    TagInfoLong EXIF_TAG_MDFILE_TAG = new TagInfoLong(
            "MDFile Tag", 0x82a5, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoRational EXIF_TAG_MDSCALE_PIXEL = new TagInfoRational(
            "MDScale Pixel", 0x82a6, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoShort EXIF_TAG_MDCOLOR_TABLE = new TagInfoShort(
            "MDColor Table", 0x82a7, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoAscii EXIF_TAG_MDLAB_NAME = new TagInfoAscii(
            "MDLab Name", 0x82a8, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoAscii EXIF_TAG_MDSAMPLE_INFO = new TagInfoAscii(
            "MDSample Info", 0x82a9, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoAscii EXIF_TAG_MDPREP_DATE = new TagInfoAscii(
            "MDPrep Date", 0x82aa, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoAscii EXIF_TAG_MDPREP_TIME = new TagInfoAscii(
            "MDPrep Time", 0x82ab, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    TagInfoAscii EXIF_TAG_MDFILE_UNITS = new TagInfoAscii(
            "MDFile Units", 0x82ac, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    List<TagInfo> ALL_MOLECULAR_DYNAMICS_GEL_TAGS =
            List.of(EXIF_TAG_MDFILE_TAG,
                    EXIF_TAG_MDSCALE_PIXEL,
                    EXIF_TAG_MDCOLOR_TABLE,
                    EXIF_TAG_MDLAB_NAME,
                    EXIF_TAG_MDSAMPLE_INFO,
                    EXIF_TAG_MDPREP_DATE,
                    EXIF_TAG_MDPREP_TIME,
                    EXIF_TAG_MDFILE_UNITS);
}
