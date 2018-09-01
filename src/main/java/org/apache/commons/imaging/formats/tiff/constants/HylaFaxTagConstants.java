package org.apache.commons.imaging.formats.tiff.constants;

import org.apache.commons.imaging.formats.tiff.taginfos.TagInfo;
import org.apache.commons.imaging.formats.tiff.taginfos.TagInfoAscii;
import org.apache.commons.imaging.formats.tiff.taginfos.TagInfoLong;

import java.util.List;

public interface HylaFaxTagConstants extends TiffFieldTypeConstants {
    public static final TagInfoLong EXIF_TAG_FAX_RECV_PARAMS = new TagInfoLong(
            "Fax Recv Params", 0x885c, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    public static final TagInfoAscii EXIF_TAG_FAX_SUB_ADDRESS = new TagInfoAscii(
            "Fax Sub Address", 0x885d, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    public static final TagInfoLong EXIF_TAG_FAX_RECV_TIME = new TagInfoLong(
            "Fax Recv Time", 0x885e, 1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    public static final TagInfoAscii EXIF_TAG_FAX_DCS = new TagInfoAscii(
            "Fax DCS", 0x885f, -1,
            TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN);

    public static final List<TagInfo> ALL_HYLAFAX_TAGS =
            List.of(EXIF_TAG_FAX_RECV_PARAMS,
                    EXIF_TAG_FAX_SUB_ADDRESS,
                    EXIF_TAG_FAX_RECV_TIME,
                    EXIF_TAG_FAX_DCS);
}
