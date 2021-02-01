import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.*;
import java.util.ArrayList;
import modelo.ModeloTabela;
import factory.ConnectionFactory;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

class relatoriousuario extends JFrame implements ActionListener{
	PreparedStatement pst; //= null;
	ResultSet rs;// = null;
    Statement stm;// = null;
	
	JButton btCod,btusuario,btemail,btendereco,btnumero,bar1,bar2,bar3;
	
	ConnectionFactory conecta  = new ConnectionFactory();
		                
    private javax.swing.JScrollPane scrollpane;
    private javax.swing.JTable jTable1;
	private	Container	
		c;
	
	public static void main (String[] args) {
		JFrame adicionar = new relatoriousuario();	
		adicionar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adicionar.setVisible(true);
	}
		

	relatoriousuario(){
		iniciaTabela();
        conecta.conexao();
       	preencherTabela("SELECT * FROM userlogin ORDER BY cod");
        
		setTitle("Relatório Usuarios");
		setSize(1100,600);//30,30,735,670
		setLocationRelativeTo(null);
		setResizable(true);//true
		c = getContentPane();
		c.setLayout(null);
                
                
		c.add(jTable1);
		
			btCod = new JButton();
  			btCod.setText("Cod");
           	btCod.setBounds(50,30,40,20);
           	btCod.setSize(67,20);
           	btCod.setBackground(new Color(27,75,153));
			btCod.setForeground(Color.white);
			btCod.setFont(new Font("Tahoma",Font.BOLD,10));
			c.add(btCod);
            
            btusuario = new JButton();
  			btusuario.setText("Usuario");
           	btusuario.setBounds(115,30,100,30);
           	btusuario.setSize(217,20);
           	btusuario.setBackground(new Color(27,75,153));
			btusuario.setForeground(Color.white);
			btusuario.setFont(new Font("Tahoma",Font.BOLD,10));
            c.add(btusuario);
            
            btemail = new JButton();
  			btemail.setText("Email");
           	btemail.setBounds(330,30,100,30);
           	btemail.setSize(308,20);
           	btemail.setBackground(new Color(27,75,153));
			btemail.setForeground(Color.white);
			btemail.setFont(new Font("Tahoma",Font.BOLD,10));
            c.add(btemail);
            
            btendereco = new JButton();
  			btendereco.setText("Endereço");
           	btendereco.setBounds(638,30,100,30);
           	btendereco.setSize(326,20);
           	btendereco.setBackground(new Color(27,75,153));
			btendereco.setForeground(Color.white);
			btendereco.setFont(new Font("Tahoma",Font.BOLD,10));
            c.add(btendereco);
            
            btnumero = new JButton();
  			btnumero.setText("Numero");
           	btnumero.setBounds(961,30,100,30);
           	btnumero.setSize(90,20);
           	btnumero.setBackground(new Color(27,75,153));
			btnumero.setForeground(Color.white);
			btnumero.setFont(new Font("Tahoma",Font.BOLD,10));
            c.add(btnumero);
            
            
            
            bar1 = new JButton();
           	bar1.setBounds(40,30,100,30);
           	bar1.setSize(10,480);
           	bar1.setBackground(new Color(27,75,153));
            c.add(bar1);
            
            bar2 = new JButton();
           	bar2.setBounds(1050,30,100,30);
           	bar2.setSize(10,480);
           	bar2.setBackground(new Color(27,75,153));
            c.add(bar2);
            
            bar3 = new JButton();
           	bar3.setBounds(50,500,100,30);
           	bar3.setSize(1000,10);
           	bar3.setBackground(new Color(27,75,153));
            c.add(bar3);
		
        }
	                          
    private void iniciaTabela() {
		scrollpane = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        
        jTable1.setBounds(50,50,1000,450);//dimensões da tabela 
        
        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] { {},{},{},{},{} },
            new String [] { }
        ));
        
        scrollpane.setViewportView(jTable1);
	}
    
	
	 public void preencherTabela(String SQL){
        ArrayList dados = new ArrayList();
        
        String[] Colunas = new String[]{"cod","usuario","email","endereco","numero"};

        try{
            conecta.executaSQL(SQL);
            conecta.rs.first();
            do{
                dados.add(new Object[]{conecta.rs.getInt("cod"),
                						conecta.rs.getString("usuario"),                				
                						conecta.rs.getString("email"),
                						conecta.rs.getString("endereco"),
                						conecta.rs.getString("numero")});
            }while(conecta.rs.next());
	}catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao preencher Arraylist: "+ex);
	}
        ModeloTabela modelo  = new ModeloTabela(dados, Colunas);
        jTable1.setModel(modelo);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(0).setResizable(false);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(190);
        jTable1.getColumnModel().getColumn(1).setResizable(false);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(280);
        jTable1.getColumnModel().getColumn(2).setResizable(false);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(300);
        jTable1.getColumnModel().getColumn(3).setResizable(false);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(4).setResizable(false);        
        jTable1.getTableHeader().setReorderingAllowed(true);
        jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }/**/

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

