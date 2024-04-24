package Server.Command;

import DATA.DataManager;

import static Server.Server.collectionHashSet;
/**
 * The command that save collection to the file
 */


public class Save extends Command {

    public Save() {
    }
    public void execute(String id){
        DataManager.Save(collectionHashSet.getHashsetCollection());
    }
}