/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.imaging.formats.tiff.constants;

import org.apache.commons.imaging.formats.tiff.taginfos.*;

import java.util.List;

public interface GpsTagConstants
        extends
            TiffFieldTypeConstants
{
    TagInfoByte GPS_TAG_GPS_VERSION_ID = new TagInfoByte(
            "GPS Version ID", 0x0000, 4,
            TiffDirectoryType.EXIF_DIRECTORY_GPS);

    // ************************************************************
    TagInfoAscii GPS_TAG_GPS_LATITUDE_REF = new TagInfoAscii(
            "GPS Latitude Ref", 0x0001, 2,
            TiffDirectoryType.EXIF_DIRECTORY_GPS);

    // ************************************************************
    TagInfoRational GPS_TAG_GPS_LATITUDE = new TagInfoRational(
            "GPS Latitude", 0x0002, 3,
            TiffDirectoryType.EXIF_DIRECTORY_GPS);

    // ************************************************************
    TagInfoAscii GPS_TAG_GPS_LONGITUDE_REF = new TagInfoAscii(
            "GPS Longitude Ref", 0x0003, 2,
            TiffDirectoryType.EXIF_DIRECTORY_GPS);

    // ************************************************************
    TagInfoRational GPS_TAG_GPS_LONGITUDE = new TagInfoRational(
            "GPS Longitude", 0x0004, 3,
            TiffDirectoryType.EXIF_DIRECTORY_GPS);

    // ************************************************************
    TagInfoByte GPS_TAG_GPS_ALTITUDE_REF = new TagInfoByte(
            "GPS Altitude Ref", 0x0005, 1,
            TiffDirectoryType.EXIF_DIRECTORY_GPS);

    // ************************************************************
    TagInfoRational GPS_TAG_GPS_ALTITUDE = new TagInfoRational(
            "GPS Altitude", 0x0006, 1,
            TiffDirectoryType.EXIF_DIRECTORY_GPS);

    // ************************************************************
    TagInfoRational GPS_TAG_GPS_TIME_STAMP = new TagInfoRational(
            "GPS Time Stamp", 0x0007, 3,
            TiffDirectoryType.EXIF_DIRECTORY_GPS);

    // ************************************************************
    TagInfoAscii GPS_TAG_GPS_SATELLITES = new TagInfoAscii(
            "GPS Satellites", 0x0008, -1,
            TiffDirectoryType.EXIF_DIRECTORY_GPS);

    // ************************************************************
    TagInfoAscii GPS_TAG_GPS_STATUS = new TagInfoAscii(
            "GPS Status", 0x0009, 2,
            TiffDirectoryType.EXIF_DIRECTORY_GPS);

    // ************************************************************
    TagInfoAscii GPS_TAG_GPS_MEASURE_MODE = new TagInfoAscii(
            "GPS Measure Mode", 0x000a, 2,
            TiffDirectoryType.EXIF_DIRECTORY_GPS);

    // ************************************************************
    TagInfoRational GPS_TAG_GPS_DOP = new TagInfoRational(
            "GPS DOP", 0x000b, 1,
            TiffDirectoryType.EXIF_DIRECTORY_GPS);

    // ************************************************************
    TagInfoAscii GPS_TAG_GPS_SPEED_REF = new TagInfoAscii(
            "GPS Speed Ref", 0x000c, 2,
            TiffDirectoryType.EXIF_DIRECTORY_GPS);

    // ************************************************************
    TagInfoRational GPS_TAG_GPS_SPEED = new TagInfoRational(
            "GPS Speed", 0x000d, 1,
            TiffDirectoryType.EXIF_DIRECTORY_GPS);

    // ************************************************************
    TagInfoAscii GPS_TAG_GPS_TRACK_REF = new TagInfoAscii(
            "GPS Track Ref", 0x000e, 2,
            TiffDirectoryType.EXIF_DIRECTORY_GPS);

    // ************************************************************
    TagInfoRational GPS_TAG_GPS_TRACK = new TagInfoRational(
            "GPS Track", 0x000f, 1,
            TiffDirectoryType.EXIF_DIRECTORY_GPS);

    // ************************************************************
    TagInfoAscii GPS_TAG_GPS_IMG_DIRECTION_REF = new TagInfoAscii(
            "GPS Img Direction Ref", 0x0010, 2,
            TiffDirectoryType.EXIF_DIRECTORY_GPS);

    // ************************************************************
    TagInfoRational GPS_TAG_GPS_IMG_DIRECTION = new TagInfoRational(
            "GPS Img Direction", 0x0011, 1,
            TiffDirectoryType.EXIF_DIRECTORY_GPS);

    // ************************************************************
    TagInfoAscii GPS_TAG_GPS_MAP_DATUM = new TagInfoAscii(
            "GPS Map Datum", 0x0012, -1,
            TiffDirectoryType.EXIF_DIRECTORY_GPS);

    // ************************************************************
    TagInfoAscii GPS_TAG_GPS_DEST_LATITUDE_REF = new TagInfoAscii(
            "GPS Dest Latitude Ref", 0x0013, 2,
            TiffDirectoryType.EXIF_DIRECTORY_GPS);

    String GPS_TAG_GPS_DEST_LATITUDE_REF_VALUE_NORTH = "N";
    String GPS_TAG_GPS_DEST_LATITUDE_REF_VALUE_SOUTH = "S";
    // ************************************************************
    TagInfoRational GPS_TAG_GPS_DEST_LATITUDE = new TagInfoRational(
            "GPS Dest Latitude", 0x0014, 3,
            TiffDirectoryType.EXIF_DIRECTORY_GPS);

    // ************************************************************
    TagInfoAscii GPS_TAG_GPS_DEST_LONGITUDE_REF = new TagInfoAscii(
            "GPS Dest Longitude Ref", 0x0015, 2,
            TiffDirectoryType.EXIF_DIRECTORY_GPS);

    // ************************************************************
    TagInfoRational GPS_TAG_GPS_DEST_LONGITUDE = new TagInfoRational(
            "GPS Dest Longitude", 0x0016, 3,
            TiffDirectoryType.EXIF_DIRECTORY_GPS);

    // ************************************************************
    TagInfoAscii GPS_TAG_GPS_DEST_BEARING_REF = new TagInfoAscii(
            "GPS Dest Bearing Ref", 0x0017, 2,
            TiffDirectoryType.EXIF_DIRECTORY_GPS);

    // ************************************************************
    TagInfoRational GPS_TAG_GPS_DEST_BEARING = new TagInfoRational(
            "GPS Dest Bearing", 0x0018, 1,
            TiffDirectoryType.EXIF_DIRECTORY_GPS);

    // ************************************************************
    TagInfoAscii GPS_TAG_GPS_DEST_DISTANCE_REF = new TagInfoAscii(
            "GPS Dest Distance Ref", 0x0019, 2,
            TiffDirectoryType.EXIF_DIRECTORY_GPS);
    // ************************************************************
    TagInfoRational GPS_TAG_GPS_DEST_DISTANCE = new TagInfoRational(
            "GPS Dest Distance", 0x001a, 1,
            TiffDirectoryType.EXIF_DIRECTORY_GPS);

    // ************************************************************
    TagInfoGpsText GPS_TAG_GPS_PROCESSING_METHOD = new TagInfoGpsText(
            "GPS Processing Method", 0x001b, FIELD_TYPE_UNKNOWN,
            -1, TiffDirectoryType.EXIF_DIRECTORY_GPS);

    // ************************************************************
    TagInfoGpsText GPS_TAG_GPS_AREA_INFORMATION = new TagInfoGpsText(
            "GPS Area Information", 0x001c, FIELD_TYPE_UNKNOWN, -1,
            TiffDirectoryType.EXIF_DIRECTORY_GPS);

    // ************************************************************
    TagInfoAscii GPS_TAG_GPS_DATE_STAMP = new TagInfoAscii(
            "GPS Date Stamp", 0x001d, 11,
            TiffDirectoryType.EXIF_DIRECTORY_GPS);

    // ************************************************************
    TagInfoShort GPS_TAG_GPS_DIFFERENTIAL = new TagInfoShort(
            "GPS Differential", 0x001e, 1,
            TiffDirectoryType.EXIF_DIRECTORY_GPS);
    // ************************************************************

    List<TagInfo> ALL_GPS_TAGS =
            List.of(
                    GPS_TAG_GPS_VERSION_ID, GPS_TAG_GPS_LATITUDE_REF,
                    GPS_TAG_GPS_LATITUDE, GPS_TAG_GPS_LONGITUDE_REF,
                    GPS_TAG_GPS_LONGITUDE, GPS_TAG_GPS_ALTITUDE_REF,
                    GPS_TAG_GPS_ALTITUDE, GPS_TAG_GPS_TIME_STAMP,
                    GPS_TAG_GPS_SATELLITES, GPS_TAG_GPS_STATUS,
                    GPS_TAG_GPS_MEASURE_MODE, GPS_TAG_GPS_DOP, GPS_TAG_GPS_SPEED_REF,
                    GPS_TAG_GPS_SPEED, GPS_TAG_GPS_TRACK_REF, GPS_TAG_GPS_TRACK,
                    GPS_TAG_GPS_IMG_DIRECTION_REF, GPS_TAG_GPS_IMG_DIRECTION,
                    GPS_TAG_GPS_MAP_DATUM, GPS_TAG_GPS_DEST_LATITUDE_REF,
                    GPS_TAG_GPS_DEST_LATITUDE, GPS_TAG_GPS_DEST_LONGITUDE_REF,
                    GPS_TAG_GPS_DEST_LONGITUDE, GPS_TAG_GPS_DEST_BEARING_REF,
                    GPS_TAG_GPS_DEST_BEARING, GPS_TAG_GPS_DEST_DISTANCE_REF,
                    GPS_TAG_GPS_DEST_DISTANCE, GPS_TAG_GPS_PROCESSING_METHOD,
                    GPS_TAG_GPS_AREA_INFORMATION, GPS_TAG_GPS_DATE_STAMP,
                    GPS_TAG_GPS_DIFFERENTIAL);
}
