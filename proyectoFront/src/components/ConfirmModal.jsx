export default function ConfirmModal({ mensaje, onConfirm, onCancel }) {
  return (
    <div className="modal-backdrop">
      <div className="modal">
        <p>{mensaje}</p>
        <button onClick={onConfirm}>Sí</button>
        <button onClick={onCancel}>No</button>
      </div>
    </div>
  );
}
