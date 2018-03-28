//
//  DoubleExtension.swift
//  ELGuideProject
//
//  Created by 宋 奎熹 on 2018/3/28.
//  Copyright © 2018年 Kuixi Song. All rights reserved.
//

import Foundation

extension Double {
    
    var toString: String {
        get {
            return String(format: "%.2f", self)
        }
    }
    
}
