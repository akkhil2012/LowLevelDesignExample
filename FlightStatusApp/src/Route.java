public class Route {

    Location from;

    Location to;

    public Location getFrom() {
        return from;
    }

    public void setFrom(Location from) {
        this.from = from;
    }

    public Location getTo() {
        return to;
    }

    public void setTo(Location to) {
        this.to = to;
    }

    public Route(Location from, Location to) {
        this.from = from;
        this.to = to;
    }



}
