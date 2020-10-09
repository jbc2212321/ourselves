#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time    : 2020/10/4 15:02
# @Author  : JBC
# @File    : UsePython.py
# @Software: PyCharm 2020.1
import re
import math
import sys


def replace_all(replace, question):
    return re.sub('|'.join(re.escape(key) for key in replace.keys()),
                  lambda k: replace[k.group(0)], question)


if __name__ == '__main__':
    subs = {"√": "math.sqrt", "sin": "math.sin", "cos": "math.cos", "tan": "math.tan", "p": " **", "q": "math.radians(",
            "h": ")"}
    answer = replace_all(subs, sys.argv[1])
    if answer.__contains__("/math.cos(math.radians(90))") or answer.__contains__("/math.sqrt(math.cos(math.radians("
                                                                                     "90)))") or answer.__contains__("/("
                                                                                                      "math.cos(math.radians(90)))**2"):
        print("无解")
    else:
        print("%.3f" % eval(answer))

