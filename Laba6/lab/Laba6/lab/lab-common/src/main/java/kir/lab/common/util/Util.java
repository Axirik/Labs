package kir.lab.common.util;

import kir.lab.common.Collection.CollectionHashSet;

 public final class Util {
    private static CollectionHashSet collectionHashSet = new CollectionHashSet("collection");


    public static CollectionHashSet getCollectionHashSet() {
        return collectionHashSet;
    }
}
