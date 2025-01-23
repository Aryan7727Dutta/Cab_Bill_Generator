public class Ride {
     double distance;
     int time;
     String rideType;
    public Ride(double distance, int time, String rideType) {
        this.distance = distance;
        this.time = time;
        this.rideType = rideType;
    }
    public double getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }

    public String getRideType() {
        return rideType;
    }
    @Override
    public String toString() {
        return "Ride{" +
                "distance=" + distance +
                ", time=" + time +
                ", rideType='" + rideType + '\'' +
                '}';
    }
}
