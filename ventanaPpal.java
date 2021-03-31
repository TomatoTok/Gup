package Gup;

import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ventanaPpal extends javax.swing.JFrame {

    DefaultTableModel tablaUsu = new DefaultTableModel();

    public ventanaPpal() throws IOException {
        initComponents();
        init();
    }

    //MIS METODOS
    public void init() throws IOException {
        setLocationRelativeTo(null);
        this.tblUsuario.setModel(tablaUsu);
        this.tablaUsu.addColumn("Correo");
        this.tablaUsu.addColumn("Usuario");
        this.tablaUsu.addColumn("Plataforma");
        this.tablaUsu.addColumn("Contraseña");
        tblUsuario.removeColumn(tblUsuario.getColumnModel().getColumn(3));
        cargarDatos();
        cambiarColorClaro();
    }

    //Metodo de carga
    public void cargarDatos() throws FileNotFoundException, IOException {
        String cadena = "";
        int cantUsu = 0;
        if (!existenciaBD()) {
            JOptionPane.showMessageDialog(null, "Se han creado ficheros nuevos.");
        }
        DataInputStream aLeerM = new DataInputStream(new FileInputStream("dataBaseM.txt"));
        while (aLeerM.available() > 0) {
            cadena = cadena + aLeerM.readUTF();
        }
        cantUsu = contarCantDatos(cadena);
        if (cantUsu == 0) {
            //Si no hay datos que cargar entonces se ahorra codigo
        } else {
            String arrMail[] = new String[cantUsu];
            String arrUsu[] = new String[cantUsu];
            String arrContra[] = new String[cantUsu];
            String arrPlat[] = new String[cantUsu];
            //Se cargan los datos de los mails
            separarDatos(cadena, arrMail);
            //Se elimina el contenido de la cadena 
            cadena = "";
            //Se cargan los datos de los usuarios
            DataInputStream aLeerU = new DataInputStream(new FileInputStream("dataBaseU.txt"));
            while (aLeerU.available() > 0) {
                cadena = cadena + aLeerU.readUTF();
            }
            separarDatos(cadena, arrUsu);
            cadena = "";
            //Se cargan los datos de las contraseñas
            DataInputStream aLeerC = new DataInputStream(new FileInputStream("dataBaseC.txt"));
            while (aLeerC.available() > 0) {
                cadena = cadena + aLeerC.readUTF();
            }
            separarDatos(cadena, arrContra);
            cadena = "";
            //Se cargan los datos de las Plataformas
            DataInputStream aLeerP = new DataInputStream(new FileInputStream("dataBaseP.txt"));
            while (aLeerP.available() > 0) {
                cadena = cadena + aLeerP.readUTF();
            }
            separarDatos(cadena, arrPlat);
            this.tblUsuario.setModel(cargarFilas(arrMail, arrUsu, arrPlat, arrContra));
        }
    }

    private boolean existenciaBD() throws FileNotFoundException {
        boolean exist = false;
        File bdM = new File("dataBaseM.txt");
        File bdU = new File("dataBaseU.txt");
        File bdC = new File("dataBaseC.txt");
        File bdP = new File("dataBaseP.txt");
        if (bdM.exists() && bdU.exists() && bdC.exists() && bdP.exists()) {
            exist = true;
        } else {
            DataOutputStream aGuardarUsu;
            DataOutputStream aGuardarMail;
            DataOutputStream aGuardarContra;
            DataOutputStream aGuardarPlat;
            aGuardarUsu = new DataOutputStream(new FileOutputStream("dataBaseU.txt"));
            aGuardarMail = new DataOutputStream(new FileOutputStream("dataBaseM.txt"));
            aGuardarContra = new DataOutputStream(new FileOutputStream("dataBaseC.txt"));
            aGuardarPlat = new DataOutputStream(new FileOutputStream("dataBaseP.txt"));
        }
        return exist;
    }

    //Cuenta la cantidad de datos que posee el string
    public int contarCantDatos(String cadena) {
        int cont = 0, i = 0, total = cadena.length();
        while (i < total) {
            if (cadena.charAt(i) == '+') {
                cont = cont + 1;
                i = i + 1;
            } else {
                i = i + 1;
            }
        }
        return cont;
    }

    //Metodo que agrega a la tabla los componentes
    public DefaultTableModel cargarFilas(String arrM[], String arrU[], String arrP[], String arrC[]) {

        for (int i = 0; i < arrM.length; i++) {
            tablaUsu.addRow(new Object[]{arrM[i], arrU[i], arrP[i], arrC[i]});
        }
        return tablaUsu;
    }

    //Metodo para separar el string en arreglos
    public void separarDatos(String cadena, String arrPal[]) throws FileNotFoundException {
        separador(arrPal, cadena);
    }

    //Metodo que te separa las palabras
    private void separador(String arrPal[], String cadena) {
        int i = 0;
        String pal = "";
        if (cadena == null || cadena.equalsIgnoreCase("")) {
        } else {
            for (int j = 0; j < cadena.length(); j++) {
                if (cadena.charAt(j) == '+' || j == cadena.length() - 1) {
                    arrPal[i] = pal;
                    System.out.println(pal);
                    pal = "";
                    i = i + 1;
                } else {
                    pal = pal + cadena.charAt(j);
                }
            }
        }
    }
//METODOS Y CODIGO CREADO POR EL GUI DE JFRAME
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTabla = new javax.swing.JPanel();
        btnBorrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuario = new javax.swing.JTable();
        lbltablaUsuarios = new javax.swing.JLabel();
        btnModo = new javax.swing.JButton();
        pnlCampos = new javax.swing.JPanel();
        lblCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JPasswordField();
        lblContrasena = new javax.swing.JLabel();
        btnVerContrasena = new javax.swing.JButton();
        cmbPlataforma = new javax.swing.JComboBox<>();
        lblPlat = new javax.swing.JLabel();
        pnlElementos = new javax.swing.JPanel();
        btnPlaystation = new javax.swing.JButton();
        btnTwitch = new javax.swing.JButton();
        btnSteam = new javax.swing.JButton();
        btnMercadoPago = new javax.swing.JButton();
        btnPaypal = new javax.swing.JButton();
        btnInstagram = new javax.swing.JButton();
        btnFacebook = new javax.swing.JButton();
        btnOutlook = new javax.swing.JButton();
        btnGmail = new javax.swing.JButton();
        btnCreditos = new javax.swing.JButton();
        btnInformacion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestor de Usuarios Personal (GUP Beta v0.1)");
        setAutoRequestFocus(false);

        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon/borrar.png"))); // NOI18N
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon/editar.png"))); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon/agregar.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon/guardar.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        tblUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuario);

        lbltablaUsuarios.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbltablaUsuarios.setText("Tabla de usuarios");

        btnModo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon/luna.png"))); // NOI18N
        btnModo.setFocusPainted(false);
        btnModo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModoActionPerformed(evt);
            }
        });

        lblCorreo.setText("Correo:");

        lblUsuario.setText("Usuario:");

        lblContrasena.setText("Contraseña:");

        btnVerContrasena.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon/vista.png"))); // NOI18N
        btnVerContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerContrasenaActionPerformed(evt);
            }
        });

        cmbPlataforma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguno", "BruBankin", "Diario", "Discord", "Facebook", "Git", "Gmail", "Instagram", "Mercado Libre", "MercadoPago", "Microsoft/Xbox", "Nintendo", "Outlook", "PayPal", "Playstation", "Pinterest", "ReBankin", "Steam", "Twitch", "Universidad", "Yahoo", "YouTube" }));

        lblPlat.setText("Plataforma:");

        javax.swing.GroupLayout pnlCamposLayout = new javax.swing.GroupLayout(pnlCampos);
        pnlCampos.setLayout(pnlCamposLayout);
        pnlCamposLayout.setHorizontalGroup(
            pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCorreo)
                    .addComponent(lblUsuario)
                    .addComponent(lblContrasena)
                    .addComponent(lblPlat))
                .addGap(18, 18, 18)
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCamposLayout.createSequentialGroup()
                        .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbPlataforma, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVerContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCamposLayout.createSequentialGroup()
                        .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlCamposLayout.setVerticalGroup(
            pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCamposLayout.createSequentialGroup()
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCamposLayout.createSequentialGroup()
                        .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCorreo))
                        .addGap(18, 18, 18)
                        .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUsuario))
                        .addGap(20, 20, 20)
                        .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblContrasena)))
                    .addComponent(btnVerContrasena, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPlataforma, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPlat))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        btnPlaystation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Reescaladas/30x30/playstation.png"))); // NOI18N
        btnPlaystation.setFocusPainted(false);
        btnPlaystation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlaystationActionPerformed(evt);
            }
        });

        btnTwitch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Reescaladas/30x30/twitch.png"))); // NOI18N
        btnTwitch.setFocusPainted(false);
        btnTwitch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTwitchActionPerformed(evt);
            }
        });

        btnSteam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Reescaladas/30x30/steam.png"))); // NOI18N
        btnSteam.setBorderPainted(false);
        btnSteam.setFocusPainted(false);
        btnSteam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSteamActionPerformed(evt);
            }
        });

        btnMercadoPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Reescaladas/30x30/mercadoPago.png"))); // NOI18N
        btnMercadoPago.setFocusPainted(false);
        btnMercadoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMercadoPagoActionPerformed(evt);
            }
        });

        btnPaypal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Reescaladas/30x30/paypal.png"))); // NOI18N
        btnPaypal.setFocusPainted(false);
        btnPaypal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaypalActionPerformed(evt);
            }
        });

        btnInstagram.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Reescaladas/30x30/instagram.png"))); // NOI18N
        btnInstagram.setFocusPainted(false);
        btnInstagram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInstagramActionPerformed(evt);
            }
        });

        btnFacebook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Reescaladas/30x30/facebook.png"))); // NOI18N
        btnFacebook.setFocusPainted(false);
        btnFacebook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacebookActionPerformed(evt);
            }
        });

        btnOutlook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Reescaladas/30x30/outlook.png"))); // NOI18N
        btnOutlook.setFocusPainted(false);
        btnOutlook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutlookActionPerformed(evt);
            }
        });

        btnGmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Reescaladas/30x30/gmail.png"))); // NOI18N
        btnGmail.setFocusPainted(false);
        btnGmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGmailActionPerformed(evt);
            }
        });

        btnCreditos.setText("Créditos");
        btnCreditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreditosActionPerformed(evt);
            }
        });

        btnInformacion.setText("Información");
        btnInformacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlElementosLayout = new javax.swing.GroupLayout(pnlElementos);
        pnlElementos.setLayout(pnlElementosLayout);
        pnlElementosLayout.setHorizontalGroup(
            pnlElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlElementosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnSteam, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(btnInstagram, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnGmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnOutlook, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPaypal, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnTwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFacebook, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlElementosLayout.createSequentialGroup()
                        .addGroup(pnlElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMercadoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPlaystation, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnInformacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCreditos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        pnlElementosLayout.setVerticalGroup(
            pnlElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlElementosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlElementosLayout.createSequentialGroup()
                        .addGroup(pnlElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnOutlook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFacebook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnInstagram, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPaypal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMercadoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(pnlElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPlaystation, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSteam, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlElementosLayout.createSequentialGroup()
                        .addComponent(btnInformacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCreditos)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlTablaLayout = new javax.swing.GroupLayout(pnlTabla);
        pnlTabla.setLayout(pnlTablaLayout);
        pnlTablaLayout.setHorizontalGroup(
            pnlTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTablaLayout.createSequentialGroup()
                .addGroup(pnlTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTablaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlTablaLayout.createSequentialGroup()
                                .addComponent(lbltablaUsuarios)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTablaLayout.createSequentialGroup()
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnModo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTablaLayout.createSequentialGroup()
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTablaLayout.createSequentialGroup()
                        .addComponent(pnlCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlElementos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlTablaLayout.setVerticalGroup(
            pnlTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTablaLayout.createSequentialGroup()
                        .addComponent(btnModo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlTablaLayout.createSequentialGroup()
                        .addComponent(lbltablaUsuarios)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlTablaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pnlElementos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//  MIS METODOS OTRA VEZ
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        if ((this.txtCorreo.getText().equalsIgnoreCase("")) || (this.txtContrasena.getText().equalsIgnoreCase("")) || (this.txtUsuario.getText().equalsIgnoreCase(""))) {
            JOptionPane.showMessageDialog(null, "Complete todas las secciones.");
        } else {
            this.tablaUsu.addRow(new Object[]{this.txtCorreo.getText(), this.txtUsuario.getText(), this.cmbPlataforma.getSelectedItem().toString(), this.txtContrasena.getText()});
            this.txtCorreo.setText("");
            this.txtUsuario.setText("");
            this.txtContrasena.setText("");
            this.cmbPlataforma.setSelectedIndex(0);
            txtCorreo.grabFocus();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        int filaSel = tblUsuario.getSelectedRow();
        if (filaSel >= 0) {
            if ((this.txtCorreo.getText().equalsIgnoreCase("")) || (this.txtContrasena.getText().equalsIgnoreCase("")) || (this.txtUsuario.getText().equalsIgnoreCase(""))) {
                JOptionPane.showMessageDialog(null, "Complete todas las secciones.");
            } else {
                String arr[] = new String[4];
                arr[0] = txtCorreo.getText();
                arr[1] = txtUsuario.getText();
                arr[2] = cmbPlataforma.getSelectedItem().toString();
                arr[3] = txtContrasena.getText();
                for (int i = 0; i < tblUsuario.getColumnCount(); i++) {
                    tablaUsu.setValueAt(arr[i], fila, i);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila.");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        //Cartel de confirmacion eliminar
        int n = JOptionPane.showConfirmDialog(this, "¿Quieres borrar esto?", "Borrar usuario", JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION) {
            int filaSel = tblUsuario.getSelectedRow();
            if (filaSel >= 0) {
                tablaUsu.removeRow(filaSel);
            } else {
                //si no se ha seleccionado ninguna fila
                JOptionPane.showMessageDialog(null, "Seleccione una fila.");
            }
            this.txtCorreo.setText("");
            this.txtUsuario.setText("");
            this.txtContrasena.setText("");
            txtCorreo.grabFocus();
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        int n = JOptionPane.showConfirmDialog(this, "¿Quieres guardar los datos?", "Guardar", JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION) {
            //Creo los ficheros a almacenar
            DataOutputStream aGuardarUsu;
            DataOutputStream aGuardarMail;
            DataOutputStream aGuardarContra;
            DataOutputStream aGuardarPlat;
            try {
                aGuardarUsu = new DataOutputStream(new FileOutputStream("dataBaseU.txt"));
                aGuardarMail = new DataOutputStream(new FileOutputStream("dataBaseM.txt"));
                aGuardarContra = new DataOutputStream(new FileOutputStream("dataBaseC.txt"));
                aGuardarPlat = new DataOutputStream(new FileOutputStream("dataBaseP.txt"));
                //Guardo los datos
                aGuardarUsu.writeUTF(recolectarDatosU());
                aGuardarUsu.close();
                aGuardarMail.writeUTF(recolectarDatosM());
                aGuardarMail.close();
                aGuardarContra.writeUTF(recolectarDatosC());
                aGuardarContra.close();
                aGuardarPlat.writeUTF(recolectarDatosP());
                aGuardarPlat.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ventanaPpal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ventanaPpal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed
//Filas de la tabla
    private int fila;

    private void tblUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuarioMouseClicked
        int filaSel = tblUsuario.getSelectedRow();
        txtCorreo.setText(tablaUsu.getValueAt(filaSel, 0).toString());
        txtUsuario.setText(tablaUsu.getValueAt(filaSel, 1).toString());
        cmbPlataforma.setSelectedItem(tablaUsu.getValueAt(filaSel,2));
        txtContrasena.setText(tablaUsu.getValueAt(filaSel, 3).toString());
        //Aca enviamos la informacion de la fila seleccionada al boton de editar
        fila = filaSel;
    }//GEN-LAST:event_tblUsuarioMouseClicked
    //variable que controla la vista de las contraseñas
    private boolean a = true;
    private void btnVerContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerContrasenaActionPerformed
        if (a) {
            txtContrasena.setEchoChar(((char) 0));
            a = false;
        } else {
            txtContrasena.setEchoChar('*');
            a = true;
        }
    }//GEN-LAST:event_btnVerContrasenaActionPerformed
    private void btnGmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGmailActionPerformed
        autoCompleta();
        txtCorreo.setText("@gmail.com");
        cmbPlataforma.setSelectedIndex(6);
    }//GEN-LAST:event_btnGmailActionPerformed
    private void btnOutlookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutlookActionPerformed
        autoCompleta();
        txtCorreo.setText("@Outlook.com");
        cmbPlataforma.setSelectedIndex(12);
    }//GEN-LAST:event_btnOutlookActionPerformed
    private void btnFacebookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacebookActionPerformed
        autoCompleta();
        cmbPlataforma.setSelectedIndex(4);
    }//GEN-LAST:event_btnFacebookActionPerformed
    private void btnInstagramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInstagramActionPerformed
        autoCompleta();
        cmbPlataforma.setSelectedIndex(7);
    }//GEN-LAST:event_btnInstagramActionPerformed
    private void btnPaypalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaypalActionPerformed
        autoCompleta();
        cmbPlataforma.setSelectedIndex(13);
    }//GEN-LAST:event_btnPaypalActionPerformed
    private void btnMercadoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMercadoPagoActionPerformed
        autoCompleta();
        cmbPlataforma.setSelectedIndex(9);
    }//GEN-LAST:event_btnMercadoPagoActionPerformed
    private void btnSteamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSteamActionPerformed
        autoCompleta();
        cmbPlataforma.setSelectedIndex(17);
    }//GEN-LAST:event_btnSteamActionPerformed
    private void btnTwitchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTwitchActionPerformed
        autoCompleta();
        cmbPlataforma.setSelectedIndex(18);
    }//GEN-LAST:event_btnTwitchActionPerformed

    private void btnPlaystationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlaystationActionPerformed
        autoCompleta();
        cmbPlataforma.setSelectedIndex(14);
    }//GEN-LAST:event_btnPlaystationActionPerformed

    private void btnInformacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformacionActionPerformed
        ventanaInformacion vent = new ventanaInformacion();
        vent.setVisible(true);
    }//GEN-LAST:event_btnInformacionActionPerformed

    private void btnCreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreditosActionPerformed
        ventanaCreditos vent = new ventanaCreditos();
        vent.setVisible(true);
    }//GEN-LAST:event_btnCreditosActionPerformed
    private boolean b=true;
    private void btnModoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModoActionPerformed
        if (b) {
            lbltablaUsuarios.setForeground(Color.decode("#FAFAFA"));
            lblCorreo.setForeground(Color.decode("#FAFAFA"));
            lblUsuario.setForeground(Color.decode("#FAFAFA"));
            lblContrasena.setForeground(Color.decode("#FAFAFA"));
            lblPlat.setForeground(Color.decode("#FAFAFA"));
            pnlCampos.setBackground(Color.decode("#3C3F41"));
            pnlElementos.setBackground(Color.decode("#666666"));
            pnlTabla.setBackground(Color.decode("#3C3F41"));
        b = false;    
        }else{
            cambiarColorClaro();
        b = true;
        }
    }//GEN-LAST:event_btnModoActionPerformed
    
        public void cambiarColorClaro(){
            lbltablaUsuarios.setForeground(Color.decode("#000000"));
            lblCorreo.setForeground(Color.decode("#000000"));
            lblUsuario.setForeground(Color.decode("#000000"));
            lblContrasena.setForeground(Color.decode("#000000"));
            lblPlat.setForeground(Color.decode("#000000"));
            pnlCampos.setBackground(Color.decode("#E7EEF0"));
            pnlElementos.setBackground(Color.decode("#D1D1D1"));
            pnlTabla.setBackground(Color.decode("#E7EEF0"));
        }
    
    public void autoCompleta() {
        //Setea valores en los campos
        txtCorreo.setText("");
        txtCorreo.grabFocus();
        txtUsuario.setText("");
        txtContrasena.setText("");
    }

    private String recolectarDatosM() {
        String cadena = "";
        for (int i = 0; i < tblUsuario.getRowCount(); i++) {

            cadena = cadena + tablaUsu.getValueAt(i, 0).toString() + "+";
        }
        System.out.println(cadena);
        return cadena;
    }

    private String recolectarDatosU() {
        String cadena = "";
        for (int i = 0; i < tblUsuario.getRowCount(); i++) {
            cadena = cadena + tablaUsu.getValueAt(i, 1).toString() + "+";
        }
        System.out.println(cadena);

        return cadena;
    }

    private String recolectarDatosC() {
        String cadena = "";
        for (int i = 0; i < tblUsuario.getRowCount(); i++) {
            cadena = cadena + tablaUsu.getValueAt(i, 3).toString() + "+";
        }
        System.out.println(cadena);
        return cadena;
    }

    private String recolectarDatosP() {
        String cadena = "";
        for (int i = 0; i < tblUsuario.getRowCount(); i++) {
            cadena = cadena + tablaUsu.getValueAt(i, 2).toString() + "+";
        }
        System.out.println(cadena);
        return cadena;
    }
//MAS METODOS DE JFRAME
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ventanaPpal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanaPpal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanaPpal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanaPpal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ventanaPpal().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(ventanaPpal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCreditos;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnFacebook;
    private javax.swing.JButton btnGmail;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnInformacion;
    private javax.swing.JButton btnInstagram;
    private javax.swing.JButton btnMercadoPago;
    private javax.swing.JButton btnModo;
    private javax.swing.JButton btnOutlook;
    private javax.swing.JButton btnPaypal;
    private javax.swing.JButton btnPlaystation;
    private javax.swing.JButton btnSteam;
    private javax.swing.JButton btnTwitch;
    private javax.swing.JButton btnVerContrasena;
    private javax.swing.JComboBox<String> cmbPlataforma;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblPlat;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lbltablaUsuarios;
    private javax.swing.JPanel pnlCampos;
    private javax.swing.JPanel pnlElementos;
    private javax.swing.JPanel pnlTabla;
    private javax.swing.JTable tblUsuario;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
