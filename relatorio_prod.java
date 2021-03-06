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

class relatorio_prod extends JFrame implements ActionListener{
	PreparedStatement pst; //= null;
	ResultSet rs;// = null;
    Statement stm;// = null;
	
	JButton btCod,btNome,btCNPJ,btIns,btEmailP,btTelF,btCidade,bar1,bar2,bar3;
	
	ConnectionFactory conecta  = new ConnectionFactory();
		                
    private javax.swing.JScrollPane scrollpane;
    private javax.swing.JTable jTable1;
	private	Container	
		c;
	
	public static void main (String[] args) {
		JFrame adicionar = new relatorio_prod();	
		adicionar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adicionar.setVisible(true);
	}
		

	relatorio_prod(){
		iniciaTabela();
        conecta.conexao();
       	preencherTabela("SELECT * FROM cadastroprod ORDER BY Cod");
        
		setTitle("Relat�rio Produtos");
		setSize(1100,600);//30,30,735,670
		setLocationRelativeTo(null);
		setResizable(true);//true
		c = getContentPane();
		c.setLayout(null);
                
                
		c.add(jTable1);
		
			btCod = new JButton();
  			btCod.setText("Codigo");
           	btCod.setBounds(50,30,40,20);
           	btCod.setSize(80,20);
           	btCod.setBackground(new Color(27,75,153));
			btCod.setForeground(Color.white);
			btCod.setFont(new Font("Tahoma",Font.BOLD,10));
			c.add(btCod);
            
            btNome = new JButton();
  			btNome.setText("Produto");
           	btNome.setBounds(128,30,100,30);
           	btNome.setSize(510,20);
           	btNome.setBackground(new Color(27,75,153));
			btNome.setForeground(Color.white);
			btNome.setFont(new Font("Tahoma",Font.BOLD,10));
            c.add(btNome);
            
            btCNPJ = new JButton();
  			btCNPJ.setText("Marca");
           	btCNPJ.setBounds(638,30,100,30);
           	btCNPJ.setSize(292,20);
           	btCNPJ.setBackground(new Color(27,75,153));
			btCNPJ.setForeground(Color.white);
			btCNPJ.setFont(new Font("Tahoma",Font.BOLD,10));
            c.add(btCNPJ);
            
            btIns = new JButton();
  			btIns.setText("Valor");
           	btIns.setBounds(930,30,100,30);
           	btIns.setSize(120,20);
           	btIns.setBackground(new Color(27,75,153));
			btIns.setForeground(Color.white);
			btIns.setFont(new Font("Tahoma",Font.BOLD,10));
            c.add(btIns);
            
            
            
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
        
        jTable1.setBounds(50,50,1000,450);//dimens�es da tabela 
        
        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] { {},{},{},{},{} },
            new String [] { }
        ));
        
        scrollpane.setViewportView(jTable1);
	}
    
	
	 public void preencherTabela(String SQL){
        ArrayList dados = new ArrayList();
        
        String[] Colunas = new String[]{"Cod","Produto1","Marca","ValorProduto"};

        try{
            conecta.executaSQL(SQL);
            conecta.rs.first();
            do{
                dados.add(new Object[]{conecta.rs.getInt("Cod"),
                						conecta.rs.getString("Produto1"),                				
                						conecta.rs.getString("Marca"),
                						conecta.rs.getString("ValorProduto")});
            }while(conecta.rs.next());
	}catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao preencher Arraylist: "+ex);
	}
        ModeloTabela modelo  = new ModeloTabela(dados, Colunas);
        jTable1.setModel(modelo);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(20);
        jTable1.getColumnModel().getColumn(0).setResizable(false);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(450);
        jTable1.getColumnModel().getColumn(1).setResizable(false);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(232);
        jTable1.getColumnModel().getColumn(2).setResizable(false);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(3).setResizable(false);        
        jTable1.getTableHeader().setReorderingAllowed(true);
        jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }/**/

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

