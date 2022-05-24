import java.util.ArrayList;

public class MyFile {
    private String fileName;
    private Directory parent;
    private ArrayList<Integer> allocatedBlocks;
    private AllocationType allocationType;
    private boolean isDeleted;

    public MyFile(String fileName) {
        this.fileName = fileName;
        isDeleted = false;
    }

    public MyFile(String fileName, ArrayList<Integer> allocatedBlocks, AllocationType allocationType) {
        this.fileName = fileName;
        this.allocatedBlocks = allocatedBlocks;
        this.allocationType = allocationType;
        this.isDeleted = false;
    }

    public ArrayList<Integer> getAllocatedBlocks() {
        return allocatedBlocks;
    }

    public void setAllocatedBlocks(ArrayList<Integer> allocatedBlocks) {
        this.allocatedBlocks = allocatedBlocks;
    }

    public void setDeleted(boolean deleted) {
        this.isDeleted = deleted;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public Directory getParent() {
        return parent;
    }

    public void setAllocationType(AllocationType allocationType) {
        this.allocationType = allocationType;
    }

    public AllocationType getAllocationType() {
        return allocationType;
    }

    public String getFilePath(){
        String filePath = fileName;
        Directory currentDirectory = parent;
        while(currentDirectory != null){
            filePath = currentDirectory.getDirectoryName() + "/" + filePath;
            currentDirectory = currentDirectory.getParent();
        }
        return filePath;
    }
}
