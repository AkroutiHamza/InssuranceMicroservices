package com.cat.storage;

import com.cat.domain.FileInfo;
import com.mongodb.gridfs.GridFSDBFile;

import java.io.InputStream;
import java.util.Optional;
import java.util.stream.Stream;


public interface FileStorage {

    FileInfo save(InputStream content, String fileName  , String contentType);

    Optional<GridFSDBFile> read(String fileId);

    Stream<GridFSDBFile> getAll();

    void deleteTestFiles(String fileName);
}
