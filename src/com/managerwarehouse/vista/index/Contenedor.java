/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managerwarehouse.vista.index;


import com.managerwarehouse.util.Variables_Gloabales;
import java.awt.BorderLayout;
import java.awt.Color;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author ZAVALA
 */
public class Contenedor extends javax.swing.JFrame {
    /*    private Control Controlador = new Control();
     private Usuarios FrmUsuarios;*/

//    private FormProducto productoII;
    static java.awt.Point Variable_Movimiento;

    public Contenedor() {
        //si no quieren borde redondeado comentan esta linea de codigo y 
        //las que les indicare dejando la letra Z
        setUndecorated(true);
        initComponents();

       //this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setSize(1010, 720);//Z
        setLocationRelativeTo(null);
        setVisible(true);
        if (Variables_Gloabales.EMPLEADO.getNivel() != 2) {
            JM_OrdenCompra.setVisible(false);
        }
        //Z ... no borde redondeado :COMENTEN ESTAS DOS LINEAS
        java.awt.Shape forma = new java.awt.geom.RoundRectangle2D.Double(0, 0, this.getBounds().width,
                this.getBounds().height, 30, 30);
        com.sun.awt.AWTUtilities.setWindowShape(this, forma);

        this.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        java.awt.Image Icono = java.awt.Toolkit.getDefaultToolkit().getImage(getClass().
                getResource("/Iconos/Planeta.png"));
        this.setIconImage(Icono);
        this.setTitle("Manager Warehouse");
        this.setForeground(Color.WHITE);

        Variable_Movimiento = null;

        //Z ... no borde redondeado :COMENTEN TODO this.addMouseListener Y this.addMouseMotionListener
        this.addMouseListener(new java.awt.event.MouseListener() {
            public void mouseReleased(java.awt.event.MouseEvent e) {
                Variable_Movimiento = null;
            }

            public void mousePressed(java.awt.event.MouseEvent e) {
                Variable_Movimiento = e.getPoint();
            }

            public void mouseExited(java.awt.event.MouseEvent e) {
            }

            public void mouseEntered(java.awt.event.MouseEvent e) {
            }

            public void mouseClicked(java.awt.event.MouseEvent e) {

                if (e.getClickCount() == 2) {
                    setExtendedState(ICONIFIED);
                    System.out.println("Double clicked on ");
                }
            }
        });

        this.addMouseMotionListener(new java.awt.event.MouseMotionListener() {
            public void mouseMoved(java.awt.event.MouseEvent e) {
            }

            public void mouseDragged(java.awt.event.MouseEvent e) {
                java.awt.Point currCoords = e.getLocationOnScreen();
                if (Variable_Movimiento != null) {
                    setLocation(currCoords.x - Variable_Movimiento.x, currCoords.y - Variable_Movimiento.y);
                }
            }
        });

        Obtener_Eventos_De_SubMenu(R_compra);
        Obtener_Eventos_De_SubMenu(JM_OrdenCompra);
        Obtener_Eventos_De_SubMenu(R_Salir);

        this.Panel_Contenedor.setBorder(new com.managerwarehouse.util.styles.Imagen_Fondo());

        this.Panel_Contenedor.setUI(new javax.swing.plaf.basic.BasicDesktopPaneUI() {
            public void paint(java.awt.Graphics g, javax.swing.JComponent c) {
                javax.swing.ImageIcon Img = new javax.swing.ImageIcon(getClass().getResource("/Iconos/Gold_Collection_Wallp.jpg"));
                g.drawImage(Img.getImage(), 0, 0, c.getWidth(), c.getHeight(), null);

            }
        });

        this.Contenedor_Menu_General.setUI(new javax.swing.plaf.basic.BasicMenuBarUI() {
            public void paint(java.awt.Graphics g, javax.swing.JComponent c) {
                // g.setColor ( java.awt.Color.RED );
                g.setColor(new java.awt.Color(61, 100, 135));
                g.fillRect(0, 0, c.getWidth(), c.getHeight());
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Contenedor = new javax.swing.JDesktopPane();
        Contenedor_Menu_General = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        R_Salida = new javax.swing.JMenuItem();
        JM_despachoproducto = new javax.swing.JMenuItem();
        Menu_Empleado = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        R_compra = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        JM_CompraProducto = new javax.swing.JMenuItem();
        JM_OrdenCompra = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenu4 = new javax.swing.JMenu();
        R_Producto = new javax.swing.JMenuItem();
        JM_Lotes = new javax.swing.JMenuItem();
        JM_DevolucionPunto = new javax.swing.JMenuItem();
        JM_DevolucionProveedor = new javax.swing.JMenuItem();
        JM_Ubicarproducto = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        JMReporte = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        JMReporteInvFisico = new javax.swing.JMenuItem();
        JMReporteInOut = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        JM_conteofisico = new javax.swing.JMenuItem();
        JM_SalidaAutorizada = new javax.swing.JMenuItem();
        JM_inventariobodega = new javax.swing.JMenuItem();
        JM_ConsumoSaldoGeneral = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        JM_inventariopunto = new javax.swing.JMenuItem();
        JM_consumosaldopunto = new javax.swing.JMenuItem();
        JM_pedidoPunto = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        JM_trasladoproducto = new javax.swing.JMenuItem();
        JM_Profile = new javax.swing.JMenu();
        R_Salir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout Panel_ContenedorLayout = new javax.swing.GroupLayout(Panel_Contenedor);
        Panel_Contenedor.setLayout(Panel_ContenedorLayout);
        Panel_ContenedorLayout.setHorizontalGroup(
            Panel_ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 920, Short.MAX_VALUE)
        );
        Panel_ContenedorLayout.setVerticalGroup(
            Panel_ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
        );

        Contenedor_Menu_General.setPreferredSize(new java.awt.Dimension(494, 70));

        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vista_style_business_and_data_icons_icons_pack_120673/carrito-de-compras-del-ecommerce-icono-4568-48.png"))); // NOI18N
        jMenu2.setText("Salidas");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        R_Salida.setBackground(new java.awt.Color(51, 51, 51));
        R_Salida.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        R_Salida.setForeground(new java.awt.Color(255, 204, 0));
        R_Salida.setText("Generar Salida");
        R_Salida.setOpaque(true);
        jMenu2.add(R_Salida);

        JM_despachoproducto.setBackground(new java.awt.Color(51, 51, 51));
        JM_despachoproducto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JM_despachoproducto.setForeground(new java.awt.Color(255, 204, 0));
        JM_despachoproducto.setText("Despachos de Producto");
        JM_despachoproducto.setActionCommand("Despachosproducto");
        JM_despachoproducto.setOpaque(true);
        jMenu2.add(JM_despachoproducto);

        Contenedor_Menu_General.add(jMenu2);

        Menu_Empleado.setForeground(new java.awt.Color(255, 255, 51));
        Menu_Empleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vista_style_business_and_data_icons_icons_pack_120673/carrito-de-la-compra-icono-7565-48.png"))); // NOI18N
        Menu_Empleado.setText("Entradas");
        Menu_Empleado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Menu_Empleado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOpaque(true);
        Menu_Empleado.add(jSeparator1);

        R_compra.setBackground(new java.awt.Color(51, 51, 51));
        R_compra.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        R_compra.setForeground(new java.awt.Color(255, 204, 0));
        R_compra.setText("Factura de Compra");
        R_compra.setActionCommand("Compra");
        R_compra.setOpaque(true);
        Menu_Empleado.add(R_compra);

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setOpaque(true);
        Menu_Empleado.add(jSeparator2);

        JM_CompraProducto.setBackground(new java.awt.Color(51, 51, 51));
        JM_CompraProducto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JM_CompraProducto.setForeground(new java.awt.Color(255, 204, 0));
        JM_CompraProducto.setText("Compra de Productos");
        JM_CompraProducto.setActionCommand("CompraProductos");
        JM_CompraProducto.setOpaque(true);
        Menu_Empleado.add(JM_CompraProducto);

        JM_OrdenCompra.setBackground(new java.awt.Color(51, 51, 51));
        JM_OrdenCompra.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JM_OrdenCompra.setForeground(new java.awt.Color(255, 204, 51));
        JM_OrdenCompra.setText("Orden de Compra");
        JM_OrdenCompra.setOpaque(true);
        Menu_Empleado.add(JM_OrdenCompra);

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(255, 153, 0));
        jSeparator3.setOpaque(true);
        Menu_Empleado.add(jSeparator3);

        Contenedor_Menu_General.add(Menu_Empleado);

        jMenu4.setForeground(new java.awt.Color(255, 255, 255));
        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vista_style_business_and_data_icons_icons_pack_120673/canasto-icono-6453-48.png"))); // NOI18N
        jMenu4.setText("Productos");
        jMenu4.setFocusable(false);
        jMenu4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        R_Producto.setBackground(new java.awt.Color(51, 51, 51));
        R_Producto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        R_Producto.setForeground(new java.awt.Color(255, 204, 0));
        R_Producto.setText("Gestionar Producto");
        R_Producto.setOpaque(true);
        jMenu4.add(R_Producto);

        JM_Lotes.setBackground(new java.awt.Color(51, 51, 51));
        JM_Lotes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JM_Lotes.setForeground(new java.awt.Color(255, 204, 0));
        JM_Lotes.setText("Lotes Almacenados");
        JM_Lotes.setOpaque(true);
        jMenu4.add(JM_Lotes);

        JM_DevolucionPunto.setBackground(new java.awt.Color(51, 51, 51));
        JM_DevolucionPunto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JM_DevolucionPunto.setForeground(new java.awt.Color(255, 204, 0));
        JM_DevolucionPunto.setText("Devolucion Punto de Entrega");
        JM_DevolucionPunto.setActionCommand("devolucionpunto");
        JM_DevolucionPunto.setOpaque(true);
        jMenu4.add(JM_DevolucionPunto);

        JM_DevolucionProveedor.setBackground(new java.awt.Color(51, 51, 51));
        JM_DevolucionProveedor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JM_DevolucionProveedor.setForeground(new java.awt.Color(255, 153, 0));
        JM_DevolucionProveedor.setText("Devolución Proveedor");
        JM_DevolucionProveedor.setActionCommand("FormDevoproveedor");
        JM_DevolucionProveedor.setOpaque(true);
        JM_DevolucionProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JM_DevolucionProveedorActionPerformed(evt);
            }
        });
        jMenu4.add(JM_DevolucionProveedor);

        JM_Ubicarproducto.setBackground(new java.awt.Color(51, 51, 51));
        JM_Ubicarproducto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JM_Ubicarproducto.setForeground(new java.awt.Color(255, 204, 0));
        JM_Ubicarproducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/bulbgrey-codigo-pin-de-ubicacion-icono-3949-32.png"))); // NOI18N
        JM_Ubicarproducto.setText("Ubicacion de Producto");
        JM_Ubicarproducto.setOpaque(true);
        jMenu4.add(JM_Ubicarproducto);

        Contenedor_Menu_General.add(jMenu4);

        jMenu1.setForeground(new java.awt.Color(255, 255, 51));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Documento.png"))); // NOI18N
        jMenu1.setText("Reportes");

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setOpaque(true);
        jMenu1.add(jSeparator4);

        JMReporte.setBackground(new java.awt.Color(51, 51, 51));
        JMReporte.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JMReporte.setForeground(new java.awt.Color(255, 153, 0));
        JMReporte.setText("Reporte de Entrada & Salidas");
        JMReporte.setActionCommand("Reporte");
        JMReporte.setOpaque(true);
        JMReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMReporteActionPerformed(evt);
            }
        });
        jMenu1.add(JMReporte);

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setOpaque(true);
        jMenu1.add(jSeparator5);

        JMReporteInvFisico.setBackground(new java.awt.Color(51, 51, 51));
        JMReporteInvFisico.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JMReporteInvFisico.setForeground(new java.awt.Color(255, 153, 0));
        JMReporteInvFisico.setText("Planilla para Inventario Fisico");
        JMReporteInvFisico.setActionCommand("invFisico");
        JMReporteInvFisico.setOpaque(true);
        JMReporteInvFisico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMReporteInvFisicoActionPerformed(evt);
            }
        });
        jMenu1.add(JMReporteInvFisico);

        JMReporteInOut.setBackground(new java.awt.Color(51, 51, 51));
        JMReporteInOut.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JMReporteInOut.setForeground(new java.awt.Color(255, 153, 0));
        JMReporteInOut.setText("Entradas/Salidas - Diarias, Semanales");
        JMReporteInOut.setActionCommand("ReporteInOut");
        JMReporteInOut.setOpaque(true);
        JMReporteInOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMReporteInOutActionPerformed(evt);
            }
        });
        jMenu1.add(JMReporteInOut);

        Contenedor_Menu_General.add(jMenu1);

        jMenu5.setForeground(new java.awt.Color(255, 255, 255));
        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vista_style_business_and_data_icons_icons_pack_120673/plantilla-de-hoja-de-calculo-de-office-x-icono-8697-48.png"))); // NOI18N
        jMenu5.setText("Inventario");

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator6.setOpaque(true);
        jMenu5.add(jSeparator6);

        JM_conteofisico.setBackground(new java.awt.Color(51, 51, 51));
        JM_conteofisico.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JM_conteofisico.setForeground(new java.awt.Color(255, 153, 0));
        JM_conteofisico.setText("Tomar Conteo Fisico");
        JM_conteofisico.setActionCommand("Formconteofisico");
        JM_conteofisico.setOpaque(true);
        JM_conteofisico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JM_conteofisicoActionPerformed(evt);
            }
        });
        jMenu5.add(JM_conteofisico);

        JM_SalidaAutorizada.setBackground(new java.awt.Color(51, 51, 51));
        JM_SalidaAutorizada.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JM_SalidaAutorizada.setForeground(new java.awt.Color(255, 153, 0));
        JM_SalidaAutorizada.setText("Salida Autorizada");
        JM_SalidaAutorizada.setOpaque(true);
        JM_SalidaAutorizada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JM_SalidaAutorizadaActionPerformed(evt);
            }
        });
        jMenu5.add(JM_SalidaAutorizada);

        JM_inventariobodega.setBackground(new java.awt.Color(51, 51, 51));
        JM_inventariobodega.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JM_inventariobodega.setForeground(new java.awt.Color(255, 153, 0));
        JM_inventariobodega.setText("Inventario Bodega");
        JM_inventariobodega.setActionCommand("Forminventariobodega");
        JM_inventariobodega.setOpaque(true);
        JM_inventariobodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JM_inventariobodegaActionPerformed(evt);
            }
        });
        jMenu5.add(JM_inventariobodega);

        JM_ConsumoSaldoGeneral.setBackground(new java.awt.Color(51, 51, 51));
        JM_ConsumoSaldoGeneral.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JM_ConsumoSaldoGeneral.setForeground(new java.awt.Color(255, 153, 0));
        JM_ConsumoSaldoGeneral.setText("Consumos y Saldos Generales");
        JM_ConsumoSaldoGeneral.setActionCommand("formconsumosaldogeneral");
        JM_ConsumoSaldoGeneral.setOpaque(true);
        JM_ConsumoSaldoGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JM_ConsumoSaldoGeneralActionPerformed(evt);
            }
        });
        jMenu5.add(JM_ConsumoSaldoGeneral);

        jSeparator7.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator7.setOpaque(true);
        jMenu5.add(jSeparator7);

        JM_inventariopunto.setBackground(new java.awt.Color(51, 51, 51));
        JM_inventariopunto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JM_inventariopunto.setForeground(new java.awt.Color(255, 153, 0));
        JM_inventariopunto.setText("Inventario Punto de Entrega");
        JM_inventariopunto.setActionCommand("forminventariopunto");
        JM_inventariopunto.setOpaque(true);
        JM_inventariopunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JM_inventariopuntoActionPerformed(evt);
            }
        });
        jMenu5.add(JM_inventariopunto);

        JM_consumosaldopunto.setBackground(new java.awt.Color(51, 51, 51));
        JM_consumosaldopunto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JM_consumosaldopunto.setForeground(new java.awt.Color(255, 153, 0));
        JM_consumosaldopunto.setText("Consumos y Saldos Finales Punto de Entrega");
        JM_consumosaldopunto.setActionCommand("formconsumosaldo");
        JM_consumosaldopunto.setOpaque(true);
        JM_consumosaldopunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JM_consumosaldopuntoActionPerformed(evt);
            }
        });
        jMenu5.add(JM_consumosaldopunto);

        JM_pedidoPunto.setBackground(new java.awt.Color(51, 51, 51));
        JM_pedidoPunto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JM_pedidoPunto.setForeground(new java.awt.Color(255, 153, 0));
        JM_pedidoPunto.setText("Pedido Punto de Entrega");
        JM_pedidoPunto.setActionCommand("formpedidopunto");
        JM_pedidoPunto.setOpaque(true);
        JM_pedidoPunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JM_pedidoPuntoActionPerformed(evt);
            }
        });
        jMenu5.add(JM_pedidoPunto);

        Contenedor_Menu_General.add(jMenu5);

        jMenu3.setBackground(new java.awt.Color(255, 255, 255));
        jMenu3.setForeground(new java.awt.Color(255, 255, 0));
        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Utilidades.png"))); // NOI18N
        jMenu3.setText("Utilidades");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        JM_trasladoproducto.setBackground(new java.awt.Color(51, 51, 51));
        JM_trasladoproducto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JM_trasladoproducto.setForeground(new java.awt.Color(255, 204, 0));
        JM_trasladoproducto.setText("Traslados de Productos");
        JM_trasladoproducto.setActionCommand("TrasladosProductos");
        JM_trasladoproducto.setOpaque(true);
        jMenu3.add(JM_trasladoproducto);

        Contenedor_Menu_General.add(jMenu3);

        JM_Profile.setBackground(new java.awt.Color(255, 255, 255));
        JM_Profile.setForeground(new java.awt.Color(255, 255, 255));
        JM_Profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Profile.png"))); // NOI18N
        JM_Profile.setToolTipText("");
        JM_Profile.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        R_Salir.setBackground(new java.awt.Color(0, 0, 0));
        R_Salir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        R_Salir.setForeground(new java.awt.Color(255, 255, 102));
        R_Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vista_style_business_and_data_icons_icons_pack_120673/liberacion-de-la-puerta-icono-9156-48.png"))); // NOI18N
        R_Salir.setText("Salir");
        R_Salir.setOpaque(true);
        JM_Profile.add(R_Salir);

        Contenedor_Menu_General.add(JM_Profile);

        setJMenuBar(Contenedor_Menu_General);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Contenedor)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Contenedor)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JMReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMReporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JMReporteActionPerformed

    private void JM_conteofisicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JM_conteofisicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JM_conteofisicoActionPerformed

    private void JMReporteInvFisicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMReporteInvFisicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JMReporteInvFisicoActionPerformed

    private void JMReporteInOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMReporteInOutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JMReporteInOutActionPerformed

    private void JM_SalidaAutorizadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JM_SalidaAutorizadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JM_SalidaAutorizadaActionPerformed

    private void JM_consumosaldopuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JM_consumosaldopuntoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JM_consumosaldopuntoActionPerformed

    private void JM_inventariopuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JM_inventariopuntoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JM_inventariopuntoActionPerformed

    private void JM_inventariobodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JM_inventariobodegaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JM_inventariobodegaActionPerformed

    private void JM_pedidoPuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JM_pedidoPuntoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JM_pedidoPuntoActionPerformed

    private void JM_ConsumoSaldoGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JM_ConsumoSaldoGeneralActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JM_ConsumoSaldoGeneralActionPerformed

    private void JM_DevolucionProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JM_DevolucionProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JM_DevolucionProveedorActionPerformed

    private void Obtener_Eventos_De_SubMenu(javax.swing.JMenuItem SubMenu) {
        SubMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evento) {
                Obtener_Resultado_Click(evento);
            }
        }
        );
    }

    private void Obtener_Resultado_Click(java.awt.event.ActionEvent evt) {
        if (evt.getActionCommand().equals("Registrar Empleados")) {

          /* if (Obtener_Estado_Formulario(null, this.Panel_Contenedor)) {

              new controllerProducto().GO();
                productoII = new FormProducto();
                Panel_Contenedor.add(productoII);
                productoII.show();
                java.awt.Dimension Tamaño_Panel = Panel_Contenedor.getSize();
                java.awt.Dimension Tamaño_InternalFrame = productoII.getSize();
                productoII.setLocation((Tamaño_Panel.width - Tamaño_InternalFrame.width) / 2,
                        (Tamaño_Panel.height - Tamaño_InternalFrame.height) / 2);
            } else {
                 
//                productoII.show(true);
                
            }*/

        } else if (evt.getActionCommand().equals("Registrar Clientes")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Aqui PONER TU SIGUIENTE FORMULARIO");
        } else if (evt.getActionCommand().equals("Salir")) {
            System.exit(0);
        }

    }

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
            java.util.logging.Logger.getLogger(Contenedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Contenedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Contenedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Contenedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Contenedor().setVisible(true);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar Contenedor_Menu_General;
    public javax.swing.JMenuItem JMReporte;
    public javax.swing.JMenuItem JMReporteInOut;
    public javax.swing.JMenuItem JMReporteInvFisico;
    public javax.swing.JMenuItem JM_CompraProducto;
    public javax.swing.JMenuItem JM_ConsumoSaldoGeneral;
    public javax.swing.JMenuItem JM_DevolucionProveedor;
    public javax.swing.JMenuItem JM_DevolucionPunto;
    public javax.swing.JMenuItem JM_Lotes;
    public javax.swing.JMenuItem JM_OrdenCompra;
    public javax.swing.JMenu JM_Profile;
    public javax.swing.JMenuItem JM_SalidaAutorizada;
    public javax.swing.JMenuItem JM_Ubicarproducto;
    public javax.swing.JMenuItem JM_consumosaldopunto;
    public javax.swing.JMenuItem JM_conteofisico;
    public javax.swing.JMenuItem JM_despachoproducto;
    public javax.swing.JMenuItem JM_inventariobodega;
    public javax.swing.JMenuItem JM_inventariopunto;
    public javax.swing.JMenuItem JM_pedidoPunto;
    public javax.swing.JMenuItem JM_trasladoproducto;
    private javax.swing.JMenu Menu_Empleado;
    public static javax.swing.JDesktopPane Panel_Contenedor;
    public javax.swing.JMenuItem R_Producto;
    public javax.swing.JMenuItem R_Salida;
    private javax.swing.JMenuItem R_Salir;
    public javax.swing.JMenuItem R_compra;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    // End of variables declaration//GEN-END:variables
}
