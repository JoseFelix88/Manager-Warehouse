package com.managerwarehouse.util.escaneo_de_soportes;

import com.managerwarehouse.util.Edicion;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import uk.co.mmscomputing.device.scanner.ScannerDevice;
import uk.co.mmscomputing.device.scanner.ScannerIOMetadata;
import uk.co.mmscomputing.device.scanner.ScannerListener;
import uk.co.mmscomputing.device.twain.TwainConstants;
import uk.co.mmscomputing.device.twain.TwainIOMetadata;
import uk.co.mmscomputing.device.twain.TwainSource;

public class EscanearSoportes implements ScannerListener {

    public int TopLeft, TopRigth, Width, Heigth;
    public double dDPI;

    public void negotiate(ScannerIOMetadata metadata) {

        ScannerDevice sd = metadata.getDevice();
        try {
            sd.setShowUserInterface(false);

            sd.setShowProgressBar(true);
            sd.setRegionOfInterest(TopLeft, TopRigth, Width, Heigth);
            sd.setResolution(dDPI);

        } catch (Exception e) {

            metadata.setCancel(true);
        }

        if (metadata instanceof TwainIOMetadata) {

            TwainSource source = null;
            try {
                source = ((TwainIOMetadata) metadata).getSource();
            } catch (Exception e) {
                if (source != null) {
                    source.setCancel(true);
                }
            }

            try {
                source.setShowProgressBar(true);
                source.setCapability(TwainConstants.ICAP_UNITS, TwainConstants.TWUN_INCHES);

            } catch (Exception e) {
            }
        }

    }

    @Override
    public void update(ScannerIOMetadata.Type type, ScannerIOMetadata siom) {

    }

    public void EjecutarScanner() {
        try {

            //Runtime.getRuntime().exec("");

        } catch (Exception e) {
            System.out.println("error al momento de abrir: " + e);
        }

    }

    public void fileMove(String origenFile, String destinoFile) throws IOException {

        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {

            File pathOrigen = new File(origenFile);
            File pathDestino = new File(destinoFile);

            if (pathDestino.exists() == false) {
                pathDestino.getParentFile().mkdirs();
            }

            inputStream = new FileInputStream(pathOrigen);
            outputStream = new FileOutputStream(pathDestino);

            int read;
            while ((read = inputStream.read()) != -1) {
                outputStream.write(read);
            }

            File file = new File(origenFile);
            if (file.exists()) {
                file.deleteOnExit();
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + ex);

        } catch (IOException ex) {
            Logger.getLogger(EscanearSoportes.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                inputStream.close();

            } catch (IOException ex) {
                Logger.getLogger(EscanearSoportes.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                outputStream.close();
            }
        }

    }

    public String getExtencionFile(String archivo){
        
        File file = new File(archivo);
        if (file == null || file.isDirectory()) {
            return "EL ARCHIVO SELECCIONADO NO ES VALIDO";
        }else if (file.isFile()) {
            
            int index = archivo.lastIndexOf('.');
            if (index == -1) {
                return null;
            }else{
                return archivo.substring(index + 1);
            }
        }
        
        return null;
    }
}
