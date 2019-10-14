package prieto.fernando.darkpicker.ui

import androidx.lifecycle.ViewModel
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import prieto.fernando.presentation.SchedulerProvider
import prieto.fernando.presentation.ViewModelProviderFactory
import javax.inject.Inject

abstract class BaseActivity<T : ViewModel> : DaggerAppCompatActivity(), BaseView<T> {

    @Inject
    protected lateinit var vmFactory: ViewModelProviderFactory<T>

    @Inject
    protected lateinit var schedulers: SchedulerProvider

    protected val subscriptions = CompositeDisposable()

    override fun onDestroy() {
        subscriptions.clear()
        super.onDestroy()
    }
}