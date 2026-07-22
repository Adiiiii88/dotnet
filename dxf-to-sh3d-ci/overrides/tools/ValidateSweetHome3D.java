import com.eteks.sweethome3d.io.HomeFileRecorder;
import com.eteks.sweethome3d.model.Home;

public final class ValidateSweetHome3D {
  private ValidateSweetHome3D() { }

  public static void main(String[] args) throws Exception {
    if (args.length != 1) {
      throw new IllegalArgumentException("Expected one .sh3d path.");
    }

    Home home = new HomeFileRecorder(0, false, null, false, true, true).readHome(args[0]);
    int levels = home.getLevels().size();
    int walls = home.getWalls().size();
    int rooms = home.getRooms().size();
    int polylines = home.getPolylines().size();
    if (levels != 3 || walls != 76 || rooms != 3 || polylines != 113) {
      throw new IllegalStateException("Sweet Home 3D read unexpected counts: levels=" + levels + ", walls=" + walls + ", rooms=" + rooms + ", polylines=" + polylines);
    }

    System.out.println("Official Sweet Home 3D HomeFileRecorder validation passed.");
    System.out.println("Levels: " + levels);
    System.out.println("Walls: " + walls);
    System.out.println("Rooms: " + rooms);
    System.out.println("Plan polylines: " + polylines);
  }
}
