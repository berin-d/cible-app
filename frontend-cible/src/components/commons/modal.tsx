import Button from "./button";

interface ModelProps {
    enable?: boolean;
    onClose: () => void;
}

export default function Modal(
    // Props
    { enable, onClose }: ModelProps) {

    // State


    // Content
    if (!enable) return null;
    return (
        <div className="fixed inset-0 bg-black/50 flex items-center justify-center"
            onClick={onClose}
        >
            <div className="bg-[#1A1A1E] p-5 rounded-lg w-96"
                onClick={(e) => e.stopPropagation()}
            >
                <h2 className="text-xl font-bold text-white mb-4">Modal Title</h2>
                <p className="text-gray-400 mb-4">This is a modal content. You can put any information here.</p>
                <Button text="Close" color="secondary" onClick={onClose} />
            </div>
        </div>
    )
}