import java.sql.*;
 
public class DataMahasiswa
{
  public static void main( String args[] ) throws Exception
  {
      connectDB();
      createDB();
      insertDB();
      selectDB();
      updateDB();
      deleteDB();
  }
   
  public static void connectDB()
  {
      Connection c = null;
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:dataMahasiswa.db");
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        System.out.println("Opened database successfully");
  }
  public static void createDB()
  {
      Connection c = null;
        Statement stmt = null;
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:dataMahasiswa.db");
          System.out.println("Opened database successfully");
 
          stmt = c.createStatement();
          String sql = "CREATE TABLE data_mahasiswa(npm int(4), nama_mhs varchar(30), prodi varchar(30), fakultas varchar(2), kelas varchar(3), dosen_pa varchar(30), tahun_angkatan int(4));";

          stmt.executeUpdate(sql);
          stmt.close();
          c.close();
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        System.out.println("Table created successfully");
  }
   
  public static void insertDB()
  {
      Connection c = null;
        Statement stmt = null;
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:dataMahasiswa.db");
          c.setAutoCommit(false);
          System.out.println("Opened database successfully");
 
          stmt = c.createStatement();
          String sql = "INSERT INTO data_mahasiswa VALUES ('1782','Arini','Informatika','FT','S3G','Surya','2012');"; 
          stmt.executeUpdate(sql);
          stmt.close();
          c.commit();
          c.close();
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        System.out.println("Records created successfully");
  }
   
  public static void selectDB()
  {
        Connection c = null;
        Statement stmt = null;
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:dataMahasiswa.db");
          c.setAutoCommit(false);
          System.out.println("Opened database successfully");
 
          stmt = c.createStatement();
          ResultSet rs = stmt.executeQuery( "SELECT * FROM data_mahasiswa;" );
          while ( rs.next() ) {
             int npm = rs.getInt("npm");
             String  nama_mhs = rs.getString("nama_mhs");
             String  prodi = rs.getString("prodi");
             String fakultas = rs.getString("fakultas");
             System.out.println( "Npm : " + npm );
             System.out.println( "Nama : " + nama_mhs );
             System.out.println( "Prodi : " + prodi );
             System.out.println( "Fakultas : " + fakultas );
             System.out.println();
          }
          rs.close();
          stmt.close();
          c.close();
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        System.out.println("Operation done successfully");  
  }
   
  public static void updateDB()
  {
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:dataMahasiswa.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");
 
      stmt = c.createStatement();
      String sql = "UPDATE data_mahasiswa set nama_mhs='Andini' where nama_mhs='Alisa';";
      stmt.executeUpdate(sql);
      c.commit();
 
      ResultSet rs = stmt.executeQuery( "SELECT * FROM data_mahasiswa;" );
      while ( rs.next() ) {
        int npm = rs.getInt("npm");
        String nama_mhs = rs.getString("nama_mhs");
        String prodi = rs.getString("prodi");
        String fakultas = rs.getString("fakultas");
        System.out.println("Npm : " + npm);
        System.out.println("Nama : " + nama_mhs);
        System.out.println("Prodi : " + prodi);
        System.out.println("Fakultas : " + fakultas);
        System.out.println();
      }
      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Operation done successfully");
  }
   
  public static void deleteDB()
  {
      Connection c = null;
        Statement stmt = null;
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:dataMahasiswa.db");
          c.setAutoCommit(false);
          System.out.println("Opened database successfully");
 
          stmt = c.createStatement();
          String sql = "DELETE from data_mahasiswa where npm=123;";
          stmt.executeUpdate(sql);
          c.commit();
 
          ResultSet rs = stmt.executeQuery( "SELECT * FROM data_mahasiswa;" );
          while ( rs.next() ) {
            int npm = rs.getInt("npm");
            String nama_mhs = rs.getString("nama_mhs");
            String prodi = rs.getString("prodi");
            String fakultas = rs.getString("fakultas");
            System.out.println("Npm : " + npm);
            System.out.println("Nama : " + nama_mhs);
            System.out.println("Prodi : " + prodi);
            System.out.println("Fakultas : " + fakultas);
            System.out.println();
          }
          rs.close();
          stmt.close();
          c.close();
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        System.out.println("Operation done successfully");
  }
}