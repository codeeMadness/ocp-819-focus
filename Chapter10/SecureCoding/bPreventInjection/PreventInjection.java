package Chapter10.SecureCoding.bPreventInjection;

import java.sql.Connection;
import java.sql.SQLException;

public class PreventInjection {

    //using Statement
    public int getOpening(Connection conn, String day) throws SQLException {
        String sql = "SELECT opens FROM hours WHERE day = '" + day +"'";
        try (var stmt = conn.createStatement();
             var rs = stmt.executeQuery(sql)) {
            if (rs.next())
                return rs.getInt("opens");
        }
        return -1;
    }

    //using PreparedStatement
    public int getOpening2(Connection conn, String day) throws SQLException {
        String sql = "SELECT opens FROM hours WHERE day = ?";
        try (var ps = conn.prepareStatement(sql)) {
            ps.setString(1, day);
            try (var rs = ps.executeQuery()) {
                if (rs.next())
                    return rs.getInt("opens");
            }
        }
        return -1;
    }

    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        PreventInjection attack = new PreventInjection();
        int evil = attack.getOpening(conn,"monday' OR day IS NOT NULL OR day = 'sunday"); // 9
        int prevented = attack.getOpening(conn,"monday' or day is not null or day = 'sunday"); // -1
    }
}
