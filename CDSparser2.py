#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Mar 29 22:58:31 2023

@author: divija
"""

import sys
sys.path.append('/Users/divija/opt/anaconda3/lib/python3.9/site-packages/')
import tabula
'''
import pandas as pd
file1 = "https://www.w3.org/WAI/WCAG21/working-examples/pdf-table/table.pdf"
table = tabula.read_pdf(r"/Users/divija/Downloads/CDS_2020-2021_FINAL.pdf",pages=8)

table2=table[1]
print(table2)
table2.to_csv("/Users/divija/Downloads/CDSDATA.csv",index=False)
'''

def cdsparse(filepath,filedestination):
    table = tabula.read_pdf(filepath,pages=8)

    table2=table[1]
    print(table2)
    table2.to_csv(filedestination,index=False)
    
    
