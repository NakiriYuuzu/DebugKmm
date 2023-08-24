//
//  ComposeView.swift
//  iOSDebugApp
//
//  Created by yuuzu on 2023/8/24.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared
import Foundation

struct ComposeView: UIViewControllerRepresentable {
    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) {}
    
    func makeUIViewController(context: Context) -> some UIViewController {
        Main_iosKt.MainViewController()
    }
}
