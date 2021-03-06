package com.test.trendingrepository.ui.main.view;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\b\u0010\u001a\u001a\u00020\u0010H\u0002J\u0016\u0010\u001b\u001a\u00020\u00102\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u0010H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/test/trendingrepository/ui/main/view/RepositoryListActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "()V", "adapter", "Lcom/test/trendingrepository/ui/main/adapter/RepositoryAdapter;", "allRepositoryList", "", "Lcom/test/trendingrepository/data/model/RepositoryDataItem;", "isNetworkAvailable", "", "searchedRepositoryList", "viewModel", "Lcom/test/trendingrepository/ui/main/viewmodel/RepositoryListViewModel;", "doNetworkCall", "", "handleLoadingBar", "isLoading", "onClick", "view", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRefresh", "setupUI", "showAllRepositories", "repositories", "showErrorMessage", "error", "", "showRetryLayout", "app_debug"})
public final class RepositoryListActivity extends androidx.appcompat.app.AppCompatActivity implements android.view.View.OnClickListener, androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener {
    private java.util.List<com.test.trendingrepository.data.model.RepositoryDataItem> allRepositoryList;
    private java.util.List<com.test.trendingrepository.data.model.RepositoryDataItem> searchedRepositoryList;
    private com.test.trendingrepository.ui.main.adapter.RepositoryAdapter adapter;
    private com.test.trendingrepository.ui.main.viewmodel.RepositoryListViewModel viewModel;
    private boolean isNetworkAvailable = false;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupUI() {
    }
    
    private final void handleLoadingBar(boolean isLoading) {
    }
    
    private final void showAllRepositories(java.util.List<com.test.trendingrepository.data.model.RepositoryDataItem> repositories) {
    }
    
    private final void showErrorMessage(java.lang.String error) {
    }
    
    private final void showRetryLayout() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View view) {
    }
    
    private final void doNetworkCall() {
    }
    
    @java.lang.Override()
    public void onRefresh() {
    }
    
    public RepositoryListActivity() {
        super();
    }
}