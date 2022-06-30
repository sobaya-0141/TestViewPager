package sobaya.app.testviewpager

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment

class BlankFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val items: List<String> = (0..1000).map {
            it.toString()
        }
        val state = mutableStateOf(items)
        return ComposeView(requireContext()).apply {
            setContent {
                MaterialTheme {
                    TestListRoute(
                        state = state
                    )
                }
            }
        }
    }

    @SuppressLint("UnrememberedMutableState")
    @Composable
    fun TestListRoute(state: State<List<String>>) {

        TestListScreen(
            items = state
        )
    }

    @Composable
    fun TestListScreen(
        items: State<List<String>>,
        modifier: Modifier = Modifier
    ) {
        LazyColumn(
            modifier = modifier.fillMaxSize()
        ) {
            items.value.forEach {
                item {
                    Text(it)
                }
            }
//            items(
//                items = items.value,
//                key = { text ->
//                    text
//                }
//            ) {
//                Text(it)
//            }
        }
    }
}
