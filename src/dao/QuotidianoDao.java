package dao;

import bean.QuotidianoBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class QuotidianoDao {
   
    private final String url = "jdbc:mysql://localhost:3306/edicola"; // Sostituisci con l'URL del tuo database
    private final String user = "root"; // Sostituisci con il tuo username
    private final String password = "";


    public boolean aggiungiPubblicazione(QuotidianoBean q) throws SQLException {
        String sql = "INSERT INTO quotidiani (nome, prezzo, aggio, cricevute, cvendute) VALUES (?, ?, ?, 0, 0)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, q.getNome());
            stmt.setDouble(2, q.getPrezzo());
            stmt.setDouble(3, q.getAggio());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean inserisciCopieRicevute(String nome, int nuoveCopie) throws SQLException {
        if (nuoveCopie <= 0) return false;
        String sql = "UPDATE quotidiani SET cricevute = cricevute + ? WHERE nome = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, nuoveCopie);
            stmt.setString(2, nome);
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean incrementaCopieVendute(String nome) throws SQLException {
        String sql = "UPDATE quotidiani SET cvendute = cvendute + 1 WHERE nome = ? AND cvendute < cricevute";
        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean modificaPrezzo(String nome, double nuovoPrezzo) throws SQLException {
        if (nuovoPrezzo <= 0) return false;
        String sql = "UPDATE quotidiani SET prezzo = ? WHERE nome = ? AND cvendute = 0";
        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, nuovoPrezzo);
            stmt.setString(2, nome);
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean modificaAggio(String nome, double nuovoAggio) throws SQLException {
        if (nuovoAggio < 5 || nuovoAggio > 20) return false;
        String sql = "UPDATE quotidiani SET aggio = ? WHERE nome = ? AND cvendute = 0";
        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, nuovoAggio);
            stmt.setString(2, nome);
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean resetGiornata() throws SQLException {
        String sql = "UPDATE quotidiani SET cricevute = 0, cvendute = 0";
        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean eliminaPubblicazione(String nome) throws SQLException {
        String sql = "DELETE FROM quotidiani WHERE nome = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            return stmt.executeUpdate() > 0;
        }
    }

    public List<QuotidianoBean> getRendiconto() throws SQLException {
        String sql = "SELECT * FROM quotidiani";
        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery(sql);
            List<QuotidianoBean> lista = new ArrayList<>();
            while (rs.next()) {
                lista.add(creaBeanDaResultSet(rs));
            }
            return lista;
        }
    }

    private QuotidianoBean creaBeanDaResultSet(ResultSet rs) throws SQLException {
        QuotidianoBean q = new QuotidianoBean();
        q.setCricevute(rs.getInt("cricevute"));
        q.setCvendute(rs.getInt("cvendute"));
        q.setPrezzo(rs.getDouble("prezzo"));
        q.setAggio(rs.getDouble("aggio"));
        q.setNome(rs.getString("nome")); 
        return q;
    }

    public boolean isNotEmpty() throws SQLException {
        String sql = "SELECT * FROM quotidiani";
        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery(sql);
            return rs.next();
        }
    }
}
