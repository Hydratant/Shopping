package com.tami.shopping.utils.ext

import java.text.DecimalFormat

fun Int.formatComma(): String = DecimalFormat("####,###").format(this)