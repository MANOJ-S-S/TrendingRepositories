package com.test.trendingrepository.ui.main.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u001bJ\u001a\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u001b2\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020 H\u0014J$\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\u0010\"\u001a\u0004\u0018\u00010\u00072\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0014\u0010\tR\'\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0019\u0010\t\u00a8\u0006$"}, d2 = {"Lcom/test/trendingrepository/ui/main/viewmodel/RepositoryListViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "errorResponse", "Landroidx/lifecycle/MutableLiveData;", "", "getErrorResponse", "()Landroidx/lifecycle/MutableLiveData;", "errorResponse$delegate", "Lkotlin/Lazy;", "mainRepository", "Lcom/test/trendingrepository/data/repository/MainRepository;", "getMainRepository", "()Lcom/test/trendingrepository/data/repository/MainRepository;", "setMainRepository", "(Lcom/test/trendingrepository/data/repository/MainRepository;)V", "progressValue", "", "getProgressValue", "progressValue$delegate", "repositoryList", "", "Lcom/test/trendingrepository/data/model/RepositoryDataItem;", "getRepositoryList", "repositoryList$delegate", "Landroidx/lifecycle/LiveData;", "getRepositories", "context", "Landroid/content/Context;", "onCleared", "", "searchRepository", "newText", "repositoryDataItem", "app_debug"})
public final class RepositoryListViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private com.test.trendingrepository.data.repository.MainRepository mainRepository;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy repositoryList$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy errorResponse$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy progressValue$delegate = null;
    private io.reactivex.disposables.CompositeDisposable compositeDisposable;
    
    @org.jetbrains.annotations.NotNull()
    public final com.test.trendingrepository.data.repository.MainRepository getMainRepository() {
        return null;
    }
    
    public final void setMainRepository(@org.jetbrains.annotations.NotNull()
    com.test.trendingrepository.data.repository.MainRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.test.trendingrepository.data.model.RepositoryDataItem>> getRepositoryList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getErrorResponse() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getProgressValue() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.test.trendingrepository.data.model.RepositoryDataItem>> getRepositories(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getProgressValue() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.test.trendingrepository.data.model.RepositoryDataItem> searchRepository(@org.jetbrains.annotations.Nullable()
    java.lang.String newText, @org.jetbrains.annotations.NotNull()
    java.util.List<com.test.trendingrepository.data.model.RepositoryDataItem> repositoryDataItem) {
        return null;
    }
    
    public RepositoryListViewModel() {
        super();
    }
}