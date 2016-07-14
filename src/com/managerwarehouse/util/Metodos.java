/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.managerwarehouse.util;

public class Metodos {
    
     public static void Guardar_Imagen(java.io.File Archivo,String Valor, String Ruta_Destino, String Nombre_Imagen,String Imagen_Temporal,int Bandera)
      {
            String Codigo="";
             try {
                 if(Bandera!=2)
                 {
                    String extension = "";
                    if(Archivo !=null)
                    {
                        Bandera_Creadora_Directorio(new java.io.File(java.io.File.separator+Ruta_Destino).mkdirs());
                        int i = Archivo.getPath().lastIndexOf('.');
                        if (i >= 0) {
                            extension = Archivo.getPath().substring(i+1);
                        }
                          java.awt.Image Capturar_Img_Solo_Lectura = javax.imageio.ImageIO.read(new java.io.File(Archivo.getPath()));
                          java.awt.Image Obtener_Imagen = Capturar_Img_Solo_Lectura.getScaledInstance(290, 250, java.awt.Image.SCALE_SMOOTH);

                          java.awt.image.BufferedImage Describir_Imagen = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().createCompatibleImage(Obtener_Imagen.getWidth(null), Obtener_Imagen.getHeight(null), java.awt.Transparency.OPAQUE);
                          Describir_Imagen.getGraphics().drawImage(Obtener_Imagen, 0, 0, null);

                           if (Nombre_Imagen !=null && Nombre_Imagen !="")
                              {
                                  Codigo=Valor;
                                  java.io.File Ruta = new java.io.File(Ruta_Destino + "/" + Nombre_Imagen);
                                    if (!Ruta.exists()){
                                        if(Imagen_Temporal !=null && Imagen_Temporal !="")
                                        {
                                             java.io.File Temporal = new java.io.File(Ruta_Destino + "/" + Imagen_Temporal);
                                                if (Temporal.exists())
                                                {
                                                    Temporal.delete();
                                                }
                                        }
                                    }
                                javax.imageio.ImageIO.write(Describir_Imagen, extension, new java.io.File(Ruta_Destino + "/" + Codigo + "_" + Archivo.getName()));     
                              }
                     }
                 
                 }else
                 {
                     if (Nombre_Imagen !=null && Nombre_Imagen !="")
                              {
                                  java.io.File Ruta = new java.io.File(Ruta_Destino + "/" + Nombre_Imagen);
                                  if (Ruta.exists())
                                  {
                                       Ruta.delete();
                                        
                                  }
                              }
                 }
                
                 } catch (java.io.IOException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
                 }
        }
     
      static void Bandera_Creadora_Directorio(boolean event) {
          if(event == true)
                  System.out.println("Creado Satisfactoriamente");
          if(event == false)
                  System.out.println("Ya Se Encuentra Creado Dicha Carpeta");
        }
      
     /* public static java.io.File Cargar_Imagen(javax.swing.JLabel Pantalla,javax.swing.JButton Boton, String Ruta_Destino,String Nombre_Imagen,String Nombre_Temporal)
      {         
                Capa_Cliente.Metodos.Dialogo.Dialogo j = new Capa_Cliente.Metodos.Dialogo.Dialogo();
                java.io.File Ruta=null;
                if(Boton.getText().toString() =="EXAMINAR")
                {
                    Ruta=j.Dialogo_Dans();
                    if(Ruta !=null)
                    {
                        Mostrar_Visualizador(Pantalla,Ruta.getPath());
                        Boton.setText("QUITAR");
                    }
                    else
                    {Boton.setText("EXAMINAR");}
                }
                else
                {
                     Boton.setText("EXAMINAR");
                     if (Nombre_Temporal ==null && Nombre_Temporal =="")
                        {
                           Nombre_Imagen="";
                           Mostrar_Imagen_Load(Pantalla);
                           System.out.println ("esta vacio el Nombre_Imagen");
                        }
                     else
                        {
                            Nombre_Imagen=Nombre_Temporal;
                            System.out.println ("esta variable en metodo Nombre_Imagen "+Nombre_Imagen);
                            Ruta = new java.io.File(Ruta_Destino + "/" + Nombre_Imagen);
                            if (Ruta.exists()){
                                Mostrar_Visualizador(Pantalla,Ruta.getPath());
                                Ruta=null;}
                            else{
                                Mostrar_Imagen_Load(Pantalla);
                                Ruta=null;}
                        }
                }
                return Ruta;
      }*/
      public static void  Mostrar_Visualizador(javax.swing.JLabel Pantalla,String Ruta_Destino) 
      {
          try
          {
          java.awt.Image Capturar_Img_Solo_Lectura = javax.imageio.ImageIO.read(new java.io.File(Ruta_Destino));
          java.awt.Image Obtener_Imagen = Capturar_Img_Solo_Lectura.getScaledInstance(Pantalla.getWidth(),Pantalla.getHeight(), java.awt.Image.SCALE_SMOOTH);
          javax.swing.Icon iconoEscalado = new javax.swing.ImageIcon(Obtener_Imagen);
          Pantalla.setIcon(iconoEscalado);
          }
          catch (java.io.IOException e) {
                 e.printStackTrace();
         }
      }
      
       public static javax.swing.Icon Mostrar_Icono_Grilla(String Ruta_Destino)
      {System.out.println("este es la ruta avatars "+Ruta_Destino);
          javax.swing.Icon iconoEscalado =null;
          try
          {
          java.awt.Image Capturar_Img_Solo_Lectura = javax.imageio.ImageIO.read(new java.io.File(Ruta_Destino));
          java.awt.Image imgEscalada = Capturar_Img_Solo_Lectura.getScaledInstance(101, 53, java.awt.Image.SCALE_SMOOTH);
          iconoEscalado = new javax.swing.ImageIcon(imgEscalada);
          }
          catch (java.io.IOException e) {
                 e.printStackTrace();
         }
          return iconoEscalado;
      }
      
      
      /*public static java.io.File Mostrar_Imagen_Load(javax.swing.JLabel Pantalla)
      {
          String directorios = System.getProperty("user.dir");
          String directorio = Capa_Cliente.Metodos.Metodos.Obtener_Ruta_Avatars().getPath();
          String Nombre ="\\Avatars\\";
          java.io.File Ruta=null;
          System.out.println (directorios+Nombre+"Avatar.gif");
          System.out.println (directorio+Nombre+"Avatar.gif");
          Ruta = new java.io.File(directorio+Nombre+"Avatar.gif");
           if (Ruta.exists()){
                                System.out.println (" existe Avatar.gif");}
                            else{
                                System.out.println (" no existe Avatar.gif");}
          Mostrar_Visualizador(Pantalla,Ruta.getPath());
          return Ruta;
      }
      
      public static java.io.File Obtener_Ruta_Avatars() {
          String Recurso = Capa_Cliente.Contenedor.class.getSimpleName() + ".class";
          java.io.File Directorio_Bin= null;
          if (Directorio_Bin == null) {
                try {

                    java.net.URL url = Capa_Cliente.Contenedor.class.getResource(Recurso);
                    if (url.getProtocol().equals("file")) {
                        java.io.File f = new java.io.File(url.toURI());
                        do {
                            f = f.getParentFile();
                        } while (!f.isDirectory());
                        Directorio_Bin = f;
                    } else if (url.getProtocol().equals("jar")) {
                        String expected = "!/" + Recurso;
                        String s = url.toString();
                        s = s.substring(4);
                        s = s.substring(0, s.length() - expected.length());
                        java.io.File f = new java.io.File(new java.net.URL(s).toURI());
                        do {
                            f = f.getParentFile();
                        } while (!f.isDirectory());
                        Directorio_Bin = f;
                    }
                } catch (Exception e) {
                    Directorio_Bin = new java.io.File(".");
                }
    }
    return Directorio_Bin;
}*/
   public static boolean Obtener_Estado_Formulario(Object obj,javax.swing.JDesktopPane Panel)
   {
        javax.swing.JInternalFrame[] Activos=Panel.getAllFrames();
        boolean cerrado=true;
        int i=0;
        while (i<Activos.length && cerrado){
            if(Activos[i]==obj){
		cerrado=false;
            }
            i++;
        }
    return cerrado;
    }
    /* public static void Ocultar_Columnas_Y_Centrar(javax.swing.JTable TuTabla, int Columna[],int Columna_Centrada)
    {
        for(int i=0;i<Columna.length;i++)
        {
             TuTabla.getColumnModel().getColumn(Columna[i]).setMaxWidth(0);
             TuTabla.getColumnModel().getColumn(Columna[i]).setMinWidth(0);
             TuTabla.getTableHeader().getColumnModel().getColumn(Columna[i]).setMaxWidth(0);
             TuTabla.getTableHeader().getColumnModel().getColumn(Columna[i]).setMinWidth(0);
        }
        for(int i=0;i<TuTabla.getColumnCount();i++)
        {
            TuTabla.getColumnModel().getColumn(i).setHeaderRenderer(new Capa_Cliente.Metodos.Color_Cabeceras(new java.awt.Color(0, 0 ,205),new java.awt.Color(255 ,193, 37)));
        }
        
        javax.swing.table.DefaultTableCellRenderer Centrar_Contenido_Letras = new javax.swing.table.DefaultTableCellRenderer();
        Centrar_Contenido_Letras.setHorizontalAlignment( javax.swing.JLabel.CENTER );
       
        for(int x=0;x<Columna_Centrada;x++){
         TuTabla.getColumnModel().getColumn(x).setCellRenderer( Centrar_Contenido_Letras );
        }
        
        TuTabla.setRowHeight(60);
        TuTabla.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
        
        TuTabla.setForeground(java.awt.Color.yellow);
        TuTabla.setBackground(java.awt.Color.BLACK);
        TuTabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);    
        TuTabla.setFillsViewportHeight(true);
        TuTabla.setShowGrid(true);
        TuTabla.setShowVerticalLines(true);
        TuTabla.setGridColor(java.awt.Color.PINK);
        
      
        
    }*/
  
     
}
