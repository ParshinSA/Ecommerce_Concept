package com.example.screen_explore.presentation.fragments

import android.app.Dialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ArrayRes
import com.example.screen_explore.R
import com.example.screen_explore.databinding.BtmSheetFragmentBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.google.android.material.textfield.TextInputLayout

class BtmSheetFragment : BottomSheetDialogFragment() {

    private var _binding: BtmSheetFragmentBinding? = null
    private val binding get() = checkNotNull(_binding)

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return BottomSheetDialog(requireContext(), R.style.styleBottomSheetDialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BtmSheetFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        action()
    }

    private fun action() {
        setDropDownMenus()
    }

    private fun setDropDownMenus() {
        setItemsMenu(binding.menuBrandContainer, R.array.arrayBrand)
        setItemsMenu(binding.menuPriceContainer, R.array.arrayPrice)
        setItemsMenu(binding.menuSizeContainer, R.array.arraySize)
    }

    private fun setItemsMenu(menu: TextInputLayout, @ArrayRes menuId: Int) {
        val containerMenu = menu.editText as MaterialAutoCompleteTextView
        val menuItems = resources.getStringArray(menuId)

        containerMenu.setText(menuItems[0])
        containerMenu.setSimpleItems(menuItems)

        containerMenu.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                containerMenu.clearFocus()
            }
        })
    }

    companion object {
        fun newInstance() = BtmSheetFragment()
    }
}