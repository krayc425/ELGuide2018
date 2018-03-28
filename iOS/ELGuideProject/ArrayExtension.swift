//
//  ArrayExtension.swift
//  ELGuideProject
//
//  Created by 宋 奎熹 on 2018/3/28.
//  Copyright © 2018年 Kuixi Song. All rights reserved.
//

import Foundation

extension Array {
    
    func shuffle() -> Array {
        var list = self
        for index in 0..<list.count {
            let newIndex = Int(arc4random_uniform(UInt32(list.count - index))) + index
            if index != newIndex {
                list.swapAt(index, newIndex)
            }
        }
        return list
    }
    
}
