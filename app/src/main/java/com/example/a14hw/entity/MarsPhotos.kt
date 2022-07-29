package com.example.a14hw.entity

interface MarsPhotos {
    val photos: List<MarsPhoto>

    object Initial: MarsPhotos {
        override val photos = listOf(MarsPhoto.initial)
    }
}

interface MarsPhoto {
    val id: Int
    val sol: Int
    val imgSrc: String
    val earthDate: String
    val camera: CameraInfoItem
    val rover: RoverInfoItem


    interface CameraInfoItem {
        val name: String

        object initial: CameraInfoItem {
            override val name = "none"
        }
    }

    interface RoverInfoItem {
        val name: String

        object initial: RoverInfoItem {
            override val name = "none"
        }
    }

    object initial: MarsPhoto {
        override val id: Int = 0
        override val sol: Int = 0
        override val imgSrc: String = "none"
        override val earthDate: String = "00-00-00"
        override val camera: CameraInfoItem = CameraInfoItem.initial
        override val rover: RoverInfoItem = RoverInfoItem.initial
    }
}
