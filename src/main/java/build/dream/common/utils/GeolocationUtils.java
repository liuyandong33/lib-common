package build.dream.common.utils;

import build.dream.common.beans.Coords;

public class GeolocationUtils {
    private static final double EE = 0.00669342162296594323;
    private static final double EARTH_RADIUS = 6378245.0;
    private static final double X_PI = Math.PI * 3000.0 / 180.0;

    public static Coords wgs84ToGcj02(double longitude, double latitude) {
        return transform(longitude, latitude);
    }

    public static Coords gcj02ToWgs84(double longitude, double latitude) {
        Coords coords = transform(longitude, latitude);
        return new Coords(longitude * 2 - coords.getLongitude(), latitude * 2 - coords.getLatitude());
    }

    public static Coords gcj02ToBd09ll(double longitude, double latitude) {
        double x = longitude;
        double y = latitude;
        double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * X_PI);
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * X_PI);
        double bd09llLongitude = z * Math.cos(theta) + 0.0065;
        double bd09llLatitude = z * Math.sin(theta) + 0.006;
        return new Coords(bd09llLongitude, bd09llLatitude);
    }

    public static Coords bd09llToGcj02(double longitude, double latitude) {
        double x = longitude - 0.0065;
        double y = latitude - 0.006;
        double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * X_PI);
        double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * X_PI);
        double gcj02Longitude = z * Math.cos(theta);
        double gcj02Latitude = z * Math.sin(theta);
        return new Coords(gcj02Longitude, gcj02Latitude);
    }

    public static Coords transform(double longitude, double latitude) {
        double dLat = transformLatitude(longitude - 105.0, latitude - 35.0);
        double dLon = transformLongitude(longitude - 105.0, latitude - 35.0);
        double radLat = latitude / 180.0 * Math.PI;
        double magic = Math.sin(radLat);
        magic = 1 - EE * magic * magic;
        double sqrtMagic = Math.sqrt(magic);
        dLat = (dLat * 180.0) / ((EARTH_RADIUS * (1 - EE)) / (magic * sqrtMagic) * Math.PI);
        dLon = (dLon * 180.0) / (EARTH_RADIUS / sqrtMagic * Math.cos(radLat) * Math.PI);
        double magicLatitude = latitude + dLat;
        double magicLongitude = longitude + dLon;
        return new Coords(magicLongitude, magicLatitude);
    }

    public static double transformLatitude(double x, double y) {
        double latitude = -100.0 + 2.0 * x + 3.0 * y + 0.2 * y * y + 0.1 * x * y + 0.2 * Math.sqrt(Math.abs(x));
        latitude += (20.0 * Math.sin(6.0 * x * Math.PI) + 20.0 * Math.sin(2.0 * x * Math.PI)) * 2.0 / 3.0;
        latitude += (20.0 * Math.sin(y * Math.PI) + 40.0 * Math.sin(y / 3.0 * Math.PI)) * 2.0 / 3.0;
        latitude += (160.0 * Math.sin(y / 12.0 * Math.PI) + 320 * Math.sin(y * Math.PI / 30.0)) * 2.0 / 3.0;
        return latitude;
    }

    public static double transformLongitude(double x, double y) {
        double longitude = 300.0 + x + 2.0 * y + 0.1 * x * x + 0.1 * x * y + 0.1 * Math.sqrt(Math.abs(x));
        longitude += (20.0 * Math.sin(6.0 * x * Math.PI) + 20.0 * Math.sin(2.0 * x * Math.PI)) * 2.0 / 3.0;
        longitude += (20.0 * Math.sin(x * Math.PI) + 40.0 * Math.sin(x / 3.0 * Math.PI)) * 2.0 / 3.0;
        longitude += (150.0 * Math.sin(x / 12.0 * Math.PI) + 300.0 * Math.sin(x / 30.0 * Math.PI)) * 2.0 / 3.0;
        return longitude;
    }

    public static double computeDistance(double longitude1, double latitude1, double longitude2, double latitude2) {
        double dx = longitude1 - longitude2;
        double dy = latitude1 - latitude2;
        double b = (latitude1 + latitude2) / 2.0;
        double lx = Math.toRadians(dx) * EARTH_RADIUS * Math.cos(Math.toRadians(b));
        double ly = EARTH_RADIUS * Math.toRadians(dy);
        return Math.sqrt(lx * lx + ly * ly);
    }
}
