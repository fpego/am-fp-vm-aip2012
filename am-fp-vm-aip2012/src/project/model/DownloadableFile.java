package project.model;

import java.io.Serializable;

public class DownloadableFile implements Serializable {
    private static final long serialVersionUID = 1L;
    private byte[] content;
    private String filename;
    private String mimeType;
    private long size;
    
    public DownloadableFile(){
        
    }
    
    public DownloadableFile(byte[] content, String filename, String mimeType){
        this.setContent(content);
        this.setFilename(filename);
        this.setMimeType(mimeType);
    }
    
    public byte[] getContent() {
        return content;
    }
    public void setContent(byte[] content) {
        this.content = content;
        this.size = content.length;
    }
    public String getFilename() {
        return filename;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }
    public String getMimeType() {
        return mimeType;
    }
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }
    
    public long getSize(){
        return this.size;
    }

}