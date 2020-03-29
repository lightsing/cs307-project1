package DataSource.models;

public class Shop {
    /**
     * create table shop (
     * id serial not null
     * constraint shop_cache_pk
     * primary key,
     * latitude double precision,
     * longitude double precision,
     * location integer
     * constraint shop_cache_location_id_fk
     * references location
     * on update cascade on delete set null,
     * rank integer
     * constraint shop_cache_rank_id_fk
     * references rank
     * on update cascade on delete set null,
     * name varchar
     * );
     */
    private int id;
    private double latitude;
    private double longitude;
    private int location;
    private int rank;
    private String name;

    public Shop(int id, double latitude, double longitude, int location, int rank, String name) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.location = location;
        this.rank = rank;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getLocation() {
        return location;
    }

    public int getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }
}
