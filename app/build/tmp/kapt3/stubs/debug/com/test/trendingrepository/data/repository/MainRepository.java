package com.test.trendingrepository.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ \u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\bH\u0002\u00a8\u0006\u000f"}, d2 = {"Lcom/test/trendingrepository/data/repository/MainRepository;", "", "()V", "getAllRepositories", "Lio/reactivex/disposables/Disposable;", "viewModel", "Lcom/test/trendingrepository/ui/main/viewmodel/RepositoryListViewModel;", "context", "Landroid/content/Context;", "insertIntoDb", "", "list", "", "Lcom/test/trendingrepository/data/model/RepositoryDataItem;", "Companion", "app_debug"})
public final class MainRepository {
    private static com.test.trendingrepository.data.repository.MainRepository mainRepository;
    private static com.test.trendingrepository.data.offline.AppDatabase db;
    private static com.test.trendingrepository.data.offline.RepositoryDao repoDao;
    @org.jetbrains.annotations.NotNull()
    public static final com.test.trendingrepository.data.repository.MainRepository.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.disposables.Disposable getAllRepositories(@org.jetbrains.annotations.NotNull()
    com.test.trendingrepository.ui.main.viewmodel.RepositoryListViewModel viewModel, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    private final void insertIntoDb(java.util.List<com.test.trendingrepository.data.model.RepositoryDataItem> list, android.content.Context context) {
    }
    
    public MainRepository() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/test/trendingrepository/data/repository/MainRepository$Companion;", "", "()V", "db", "Lcom/test/trendingrepository/data/offline/AppDatabase;", "mainRepository", "Lcom/test/trendingrepository/data/repository/MainRepository;", "repoDao", "Lcom/test/trendingrepository/data/offline/RepositoryDao;", "instance", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.test.trendingrepository.data.repository.MainRepository instance() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}